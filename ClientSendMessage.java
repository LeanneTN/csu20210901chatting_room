package com.DencendOO.service;

import com.DencendOO.Main;
import com.DencendOO.common.Message;
import com.DencendOO.common.MessageType;
import com.DencendOO.common.User;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

//该类提供向服务器发送消息的方法
public class ClientSendMessage {
    public static User u = new User();
    public static Socket socket;

    //登录
    public boolean isLogIn(int userId,String password){
        //登录是否成功
        boolean flag = false;

        u.setUserId(userId);
        u.setPassword(password);

        //构建Message
        Message message = new Message();
        message.setSender(u);
        message.setMessageType(MessageType.MESSAGE_LOGIN);
        //将登录的信息发送给服务器
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到ObjectOutputStream对象,发送登录请求
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

            //接收服务端的回复
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if(ms.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//登录成功
                u = ms.getGetter();
                //创建一个和服务端保持通讯的线程-> 创建类ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端的线程
                clientConnectServerThread.start();
                //这里为了方便后续拓展，将线程放入到集合中
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                flag = true;

                //将主页打开
                Main.homeScene.getNicknameLabel().setText("昵称：" + u.getNickname());
                Main.homeScene.getAccountLabel().setText("账号：" + u.getUserId());
                Main.homeScene.setVisible(true);
                Main.homeScene.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                //请求获取自己的好友列表
                getMyFriends(u);
            }
            else{
                //关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //注册，判断账号是否存在
    public boolean isUserIdExist(int userId,String password,String nickname){
        boolean flag = true;

        u.setUserId(userId);
        u.setPassword(password);
        u.setNickname(nickname);

        //构建Message
        Message message = new Message();
        message.setSender(u);
        message.setMessageType(MessageType.MESSAGE_REGISTER);
        //将注册的信息发送给服务器
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到ObjectOutputStream对象,发送登录请求
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

            //接收服务端的回复
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if(ms.getMessageType().equals(MessageType.MESSAGE_REGISTER_SUCCEED)){//注册成功
                flag = false;
            }
            else{
                //关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //向服务端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u);
        try {
            //发送给服务器，应该得到当前线程的socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务端发送下线请求
    public void logout(){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u);
        try {
            //发送信息
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ClientConnectServerThread.controlRun = false;
            oos.writeObject(message);
            System.out.println(u.getUserId() + "下线了");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //私聊
    public void sendMessageToOne(String content, User sender, User getter){
        //构建Message
        Message message = new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        message.setMessageType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new java.util.Date().toString());
        System.out.println(sender.getUserId() + "对" + getter.getUserId() + "说" + content);
        try {
            //发送给服务器
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //群聊
    public void sendMessageToAll(String content,User sender){
        //构建Message
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setMessageType(MessageType.MESSAGE_GROUP_MES);
//        message.setSendTime(new java.util.Date().toString());
        System.out.println(sender.getUserId() + "对所有人说" + content);
        try {
            //发送给服务器
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sender.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器请求获取自己的好友列表
    public void getMyFriends(User sender){
        //构建Message
        Message message = new Message();
        message.setSender(sender);
        message.setMessageType(MessageType.MESSAGE_GET_ALL_FRIEND);
        try {
            //发送给服务器
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sender.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器请求添加一个好友
    public void addFriend(User sender,int friendId){
        //构建Message
        Message message = new Message();
        message.setSender(sender);
        message.setContent(String.valueOf(friendId));
        message.setMessageType(MessageType.MESSAGE_ADD_FRIEND);

        try {
            //发送给服务器
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sender.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器请求删除一个好友
    public void removeFriend(User sender,int friendId){
        //构建Message
        Message message = new Message();
        message.setSender(sender);
        message.setContent(String.valueOf(friendId));
        message.setMessageType(MessageType.MESSAGE_REMOVE_FRIEND);

        try {
            //发送给服务器
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sender.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
