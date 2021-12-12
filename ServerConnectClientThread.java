package com.DencendOO.service;


import com.DencendOO.common.Message;
import com.DencendOO.common.MessageType;
import com.DencendOO.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

//该类的对象和某个客户端保持通信,主要是根据客户端发来Message的类型，给予相应的反馈
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private int userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, int userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {//线程处于run的状态，可以接收/发送消息
        while (true) {
            try {
                //读取数据
                System.out.println("服务端和客户端" + userId + "保持通信，读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //根据Message的类型，做相应的反馈
                //客户端要获取在线用户
                if(message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    returnOnlineFriend();
                }
                //客户端要退出
                else if(message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender().getUserId() + "即将退出");
                    //将这个客户端对应的线程移除
                    clientLogOut(message.getSender());
                    break;//退出线程
                }
                //客户端要私聊
                else if(message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)){
                    returnMessageToOne(message);
                }
                //客户端群发消息
                else if(message.getMessageType().equals((MessageType.MESSAGE_GROUP_MES))){
                    returnMessageToAll(message);
                }
                //客户端要添加一个好友
                else if(message.getMessageType().equals(MessageType.MESSAGE_ADD_FRIEND)){
                    //要添加谁
                    int friendId = Integer.valueOf(message.getContent());
                    addFriendForClient(message.getSender(),friendId);
                }
                //客户端要移除一个好友
                else if(message.getMessageType().equals(MessageType.MESSAGE_REMOVE_FRIEND)){
                    //要删除谁
                    int friendId = Integer.valueOf(message.getContent());
                    removeFriendForClient(message.getSender(),friendId);
                }
                //客户端要获取自己的好友列表
                else if(message.getMessageType().equals(MessageType.MESSAGE_GET_ALL_FRIEND)){

                }
                else{

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    //这条信息是当一个用户登录/注册成功 或者 下线 时，向所有用户发送的，用于更新当前在线的用户
    public void returnOnlineFriend() throws IOException{
        //创建Message
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
        int[] onlineUserIds = ManageClientThread.getOnlineUser();
        User[] onlineUsers = new User[onlineUserIds.length];
        try {
            for(int i = 0;i < onlineUserIds.length;i++){
                onlineUsers[i] = new User();
                onlineUsers[i].setUserId(onlineUserIds[i]);
                onlineUsers[i].setNickname(DatabaseOperate.getNickName(onlineUserIds[i]));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        message.setUsersList(onlineUsers);

        //遍历管理线程的集合，把所有的socket得到，然后对message进行发送
        HashMap<Integer, ServerConnectClientThread> hm = ManageClientThread.getHm();

        Iterator<Integer> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            int onlineUserId = iterator.next();
            //进行发送
            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
            oos.writeObject(message);
        }
    }

    //当一个用户上线时，向所有在线用户提示XXX上线了
    public void newLogIn(User newClient) throws IOException{
        //创建消息
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_NEW_LOGIN);
        message.setSender(newClient);

        //遍历管理线程的集合，把所有的socket得到，然后对message进行转发
        HashMap<Integer, ServerConnectClientThread> hm = ManageClientThread.getHm();
        Iterator<Integer> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            int onlineUserId = iterator.next();
            //进行转发
            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
            oos.writeObject(message);
        }
    }

    //接收到用户的下线请求时，做下线处理。下线后，向所有用户更新在线用户，并发送XXX下线了
    public void clientLogOut(User userLogOut) throws IOException{
        ManageClientThread.removeServerConnectClientThread(userLogOut.getUserId());
        socket.close();
        returnOnlineFriend();

        //创建消息
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_NEW_LOGOUT);
        message.setSender(userLogOut);

        //遍历管理线程的集合，把所有的socket得到，然后对message进行转发
        HashMap<Integer, ServerConnectClientThread> hm = ManageClientThread.getHm();
        Iterator<Integer> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            int onlineUserId = iterator.next();
            //进行转发
            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
            oos.writeObject(message);
        }
    }

    //接收到用户私聊请求后，将消息转发给目标
    public void returnMessageToOne(Message message) throws IOException{
        //根据message获取getterId，然后得到对应的线程
        ServerConnectClientThread scct = ManageClientThread.getServerConnectClientThread(message.getGetter().getUserId());
        //得到对应的socket对象的输出流
        ObjectOutputStream oos = new ObjectOutputStream(scct.getSocket().getOutputStream());
        oos.writeObject(message);//将信息发送给信息的接收者
    }

    //接收到用户群发请求后，将消息转发给所有在线用户
    public void returnMessageToAll(Message message) throws IOException{
        //遍历管理线程的集合，把所有的socket得到，然后对message进行转发
        HashMap<Integer, ServerConnectClientThread> hm = ManageClientThread.getHm();

        Iterator<Integer> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            //取出在线用户的id
            int onlineUserId = iterator.next();
            //进行转发
            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
            oos.writeObject(message);
        }
    }

    //接收到用户添加好友请求后，给与相应的反馈
    public void addFriendForClient(User u,int friendId) throws IOException{
        System.out.println("谁要添加好友" + u.getUserId() + "\n添加谁" + friendId);
        //构建消息
        Message message = new Message();
        //如果添加好友成功了，一是要告诉用户添加成功，另外要更新好友列表
        if(addFriendInDatabase(u.getUserId(),friendId)) {
            message.setMessageType(MessageType.MESSAGE_ADD_FRIEND_SUCCEED);
            returnAllFriends(u);
        }
        else
            message.setMessageType(MessageType.MESSAGE_ADD_FRIEND_FAIL);

        //发送消息
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
    }

    //接收到用户删除好友请求后，给予相应的反馈
    public void removeFriendForClient(User u,int friendId) throws IOException{
        //构建消息
        Message message = new Message();
        if(removeFriendInDatabase(u.getUserId(),friendId)) {
            message.setMessageType(MessageType.MESSAGE_REMOVE_FRIEND_SUCCEED);
            returnAllFriends(u);
        }
        else {
            message.setMessageType(MessageType.MESSAGE_REMOVE_FRIEND_FAIL);
        }

        //发送消息
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
    }

    //接收到用户获取所有好友的请求后，给予相应的反馈
    public void returnAllFriends(User sender){
        //创建消息
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_FRIENDS);
        message.setGetter(sender);
        try {
            //如果用户根本没有好友
            if(DatabaseOperate.getFriends(sender.getUserId()) == null){
                message.setUsersList(null);
            }
            //如果用户是有好友的
            else{
                int[] friendIds = DatabaseOperate.getFriends(sender.getUserId());
                User[] friends = new User[friendIds.length];
                for (int i = 0;i < friendIds.length;i++){
                    friends[i] = new User();
                    friends[i].setUserId(friendIds[i]);
                    friends[i].setNickname(DatabaseOperate.getNickName(friendIds[i]));
                }
                message.setUsersList(friends);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将消息发送给客户端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //以下代码涉及数据库操作

    //为账号userId（这个账号一定存在）添加一个好友friendId(即为friends属性追加字符串“friendId#”)
    //首先检查friendId是否存在（有没有这个账号），然后检查用户是否已经加过这个人了
    //如果根本没有friendId这个账号，或者用户已经加过这个人了，返回false
    //如果有friendId这个账号，且用户没有加过这个人，将其追加到friends，并返回true
    public boolean addFriendInDatabase(int userId,int friendId){
        try {
            if(!DatabaseOperate.selectAccount(friendId))      //此处判断是否在数据库内
            {
                return false;
            }
            return DatabaseOperate.addFriends(userId,friendId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //为账号userId（这个账号一定存在）删除一个好友friendId(即为friends属性 删除 其中的“friendId#”)
    //检查用户的friends中是否有friendId
    //如果没有（没加过这个好友），返回false
    //如果有（确实加过），将其在friends中删除，并返回true
    public boolean removeFriendInDatabase(int userId,int friend){
        try {
            return DatabaseOperate.deleteFriends(userId, friend);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //由用户id获取该用户的好友列表
    public int[] getAllFriendsInDatabase(int userId){
        try {
            return DatabaseOperate.getFriends(userId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };
}