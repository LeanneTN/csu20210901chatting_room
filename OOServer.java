package com.DencendOO.service;

import com.DencendOO.common.Message;
import com.DencendOO.common.User;
import com.DencendOO.common.MessageType;

import com.DencendOO.common.Message;
import com.DencendOO.common.MessageType;
import com.DencendOO.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;

//服务端，监听9999，等待客户端连接，并保持通信。
//该类用于：建立数据库，响应用户的登录和注册请求
public class OOServer {
    private ServerSocket ss = null;

    //--------------注意：后续以下代码需要改成建立数据库，数据库查找---------------------
//    //注意，每个用户有以下几个属性 userId(int)，password(String),nickname(String),friends(String)
//
    //该集合是临时存储的用户名和密码
//    private static HashMap<Integer, User> validUsers = new HashMap<Integer, User>();
//
//    //初始化用户找账号和密码
//    static {
//        validUsers.put(1,new User(1,"123456"));
//        validUsers.put(2,new User(2,"123456"));
//        validUsers.put(3,new User(3,"123456"));
//        validUsers.put(4,new User(4,"123456"));
//        validUsers.put(5,new User(5,"123456"));
//    }
//
//    //在登录时验证账号是否存在，以及密码是否正确
//    private boolean checkUser(int userId,String password){
//        User user = validUsers.get(userId);
//        if(user == null){//账号不存在
//            return false;
//        }
//        else if(!user.getPassword().equals(password)){//账号存在，但密码不对
//            return false;
//        }
//        return true;
//    }
//
//    //在注册时查看账号是否被占用（如果存在返回true，如果不存在，将这个用户放入数据库并返回false）
//    private boolean isUserIdExist(int userId,String password,String nickname){
//        return false;
//    }

    //------------------------------------------------------------------------

    //-------------------------------以下为数据库相关代码-------------------------------
    //在登陆时验证账号是否存在，以及密码是否正确
    private boolean checkUser(int userId,String password){
        System.out.println("用户输入的账号" + userId + "输入密码" + password);
        try {
            if(!DatabaseOperate.selectAccount(userId)){ //账号不存在
                return false;
            }
            else if(!DatabaseOperate.selectLogin(userId,password)){  //账号存在但密码错误
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("账号存在");
        return true;
    }

    //在注册时查看账号是否被占用（如果存在返回true，如果不存在，将这个用户放入数据库并返回false）
    private boolean isUserIdExist(int userId,String password,String nickname){
        try {
            if(DatabaseOperate.selectAccount(userId)){//账号已被占用
                return true;
            }
            else{  //该账号未被占用，将用户信息插入数据库并返回false
                DatabaseOperate.insert(nickname,userId,password);
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    //-------------------------------数据库相关代码到此结束--------------------------------------

    public OOServer(){
        try {
            System.out.println("服务端在9999端口监听");
            ss = new ServerSocket(9999);
            //服务端一直在监听，当和某个客户端建立连接后，继续监听
            while(true){
                //如果没有客户端连接，就会阻塞
                Socket socket = ss.accept();
                //得到socket关联对象的输入流(读取信息)和输出流(发送信息)
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //读取来自客户端的消息
                Message message = (Message)ois.readObject();

                //创建一个Message对象，准备回复客户端
                Message reply = new Message();


                //如果用户申请登录
                if(message.getMessageType().equals(MessageType.MESSAGE_LOGIN))
                {
                    //验证用户名和密码是否正确
                    if(checkUser(message.getSender().getUserId(),message.getSender().getPassword())){//登录成功
                        System.out.println("用户名是" + message.getSender().getUserId() + "密码是" + message.getSender().getPassword());
                        reply.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        User newClient = message.getSender();
                        newClient.setNickname(DatabaseOperate.getNickName(newClient.getUserId()));
                        reply.setGetter(newClient);

                        //回复客户端
                        oos.writeObject(reply);
                        //创建一条线程，和客户端保持通信，该线程需要持有socket对象
                        ServerConnectClientThread scct = new ServerConnectClientThread(socket, message.getSender().getUserId());
                        scct.start();
                        //把该线程放入到一个集合中，方便管理
                        ManageClientThread.addClientThread(message.getSender().getUserId(),scct);

                        //用户登录后，为用户查询其好友
                        scct.returnAllFriends(newClient);

                        //每有一个用户登录，就向所有的用户发送 “当前所有在线用户”和“xxx上线了”
                        scct.returnOnlineFriend();
                        scct.newLogIn(newClient);
                    }
                    else{   //登陆失败
                        reply.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                        oos.writeObject(reply);
                        //关闭socket和流
                        oos.close();
                        ois.close();
                        socket.close();
                    }
                }
                //用户申请注册
                else if(message.getMessageType().equals(MessageType.MESSAGE_REGISTER)){
                    //如果账号已经被占用了（注册失败）
                    if(isUserIdExist(message.getSender().getUserId(),message.getSender().getPassword(),message.getSender().getNickname())){
                        reply.setMessageType(MessageType.MESSAGE_REGISTER_FAIL);
                    }
                    //如果账号可用
                    else{
                        reply.setMessageType(MessageType.MESSAGE_REGISTER_SUCCEED);
                    }

                    oos.writeObject(reply);
                    System.out.println("已对用户注册请求做出回复" + reply.getMessageType());
                    //关闭socket和流
                    oos.close();
                    ois.close();
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //如果服务端退出了while循环，说明服务端不再监听，因此需要关闭资源
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
