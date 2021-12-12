package com.DencendOO.service;

import com.DencendOO.Main;
import com.DencendOO.common.Message;
import com.DencendOO.common.MessageType;
import com.DencendOO.common.User;
import com.DencendOO.scene.ChatScene;
import com.DencendOO.scene.HomeScene;
import com.DencendOO.scene.RoomScene;
import org.jdesktop.swingx.HorizontalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.net.Socket;

//该类用于接收服务端的消息并做处理
public class ClientConnectServerThread extends Thread{
    //该线程需要持有socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    //为了更方便的得到Socket
    public Socket getSocket(){
        return socket;
    }

    public static boolean controlRun = true;

    @Override
    public void run(){
        //因为线程需要在后台和服务器通信，所以我们使用while循环
        while (controlRun){
            try {
                System.out.println("客户端线程等待读取从服务端发送的消息");
                //如果服务器没有发送Message对象，则线程会阻塞在这里
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //如果服务端发来了Message对象，判断message类型，然后做相应处理
                //返回所有在线用户
                if(message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){
                    //取出在线用户列表信息
                    User[] onlineUsers = message.getUsersList();
                    String[] onlineUsersInfo = new String[onlineUsers.length];
                    for(int i = 0;i < onlineUsers.length;i++){
                        onlineUsersInfo[i] = onlineUsers[i].getNickname() + "【" + onlineUsers[i].getUserId() + "】";
                    }
                    //将用户信息显示到聊天界面上
                    Main.roomScene.getOnlineUsers().setListData(onlineUsersInfo);
                }
                //返回私聊消息
                else if(message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)){//如果是普通的聊天消息
                    //把从服务器转发的消息显示到消息框
                    ChatScene friendScene = Main.returnChatSceneByFriendId(message.getSender().getUserId());
                    friendScene.setVisible(true);

                    String oldContent = friendScene.getScreen().getText();
                    String friendMes = message.getSender().getNickname() + "说：\n" + message.getContent() + "\n\n";
                    friendScene.getScreen().setText(oldContent + friendMes);
                }
                //返回新用户登录消息
                else if(message.getMessageType().equals(MessageType.MESSAGE_NEW_LOGIN)){
                    String newMes = message.getSender().getNickname() + "上线了\n\n";
                    Main.roomScene.setTextInScreen(Main.roomScene.getScreen().getText() + newMes);
                }
                //返回用户下线消息
                else if(message.getMessageType().equals(MessageType.MESSAGE_NEW_LOGOUT)){
                    String newMes = message.getSender().getNickname() + "下线了\n\n";
                    Main.roomScene.setTextInScreen(Main.roomScene.getScreen().getText() + newMes);
                }
                //返回群聊消息
                else if(message.getMessageType().equals(MessageType.MESSAGE_GROUP_MES)){
                    String newMes = message.getSender().getNickname() + "说:\n" + message.getContent() + "\n\n";
                    Main.roomScene.setTextInScreen(Main.roomScene.getScreen().getText() + newMes);
                }
                //添加好友成功
                else if(message.getMessageType().equals(MessageType.MESSAGE_ADD_FRIEND_SUCCEED)){
                    //弹出提示框
                    Main.homeScene.addFriendSucceed();
                    //重新获取好友列表
                    Main.clientSendMessage.getMyFriends(Main.clientSendMessage.u);
                }
                //添加好友失败
                else if(message.getMessageType().equals(MessageType.MESSAGE_ADD_FRIEND_FAIL)){
                    //弹出提示框
                    Main.homeScene.addFriendFail();
                }
                //删除好友成功
                else if(message.getMessageType().equals(MessageType.MESSAGE_REMOVE_FRIEND_SUCCEED)){
                    //弹出提示框
                    Main.homeScene.removeFriendSucceed();
                }
                //删除好友失败
                else if(message.getMessageType().equals(MessageType.MESSAGE_REMOVE_FRIEND_FAIL)){
                    //弹出提示框
                    Main.homeScene.removeFriendFail();
                }
                //获得自己的好友列表
                else if(message.getMessageType().equals(MessageType.MESSAGE_CLIENT_FRIENDS)){
                    User[] friends = message.getUsersList();
                    if(friends != null)
                    {
                        if(friends.length < 5){
                            Main.homeScene.getFriendList().setLayout(new GridLayout(5,1,10,10));
                        }
                        else {
                            Main.homeScene.getFriendList().setLayout(new GridLayout(friends.length,1,10,10));
                        }

                        //以下是对于私聊界面的初始化
                        Main.chatScene = new ChatScene[friends.length];
                        for(int i = 0;i < friends.length;i++){
                            Main.chatScene[i] = new ChatScene(friends[i].getUserId(),friends[i].getNickname());
                            Main.chatScene[i].setTitle(friends[i].getNickname());
                        }

                        //以下是对于主界面的初始化
                        Main.homeScene.getFriendList().removeAll();
                        for(int i = 0;i < friends.length;i++){
                            //按下好友头像后的处理
                            class FriendPicListener implements ActionListener {
                                int friendIndex;

                                public FriendPicListener(int friendIndex){
                                    this.friendIndex = friendIndex;
                                }

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Main.chatScene[friendIndex].setVisible(true);
                                }
                            }

                            JPanel mainFrame = new JPanel(new HorizontalLayout(10));
                            JPanel infoFrame = new JPanel(new GridLayout(3,1,10,3));

                            JButton friendPic = new JButton();
                            friendPic.addActionListener(new FriendPicListener(i));

                            friendPic.setIcon(new ImageIcon("src/com/DencendOO/icon/User.png"));
                            friendPic.setPreferredSize(new Dimension(60,60));
                            friendPic.setMinimumSize(new Dimension(60,60));
                            friendPic.setMaximumSize(new Dimension(60,60));

                            JLabel nicknameLabel = new JLabel("昵称：" + friends[i].getNickname());
                            nicknameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                            JLabel friendIdLabel = new JLabel("账号：" + friends[i].getUserId());
                            friendIdLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

                            JLabel statusLabel = new JLabel("状态：");
                            statusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

                            infoFrame.add(nicknameLabel);
                            infoFrame.add(friendIdLabel);
                            infoFrame.add(statusLabel);

                            mainFrame.add(friendPic);
                            mainFrame.add(infoFrame);

                            Main.homeScene.getFriendList().add(mainFrame);
                        }
                        Main.homeScene.getFriendList().updateUI();
                    }
                    else
                    {
                        Main.homeScene.getFriendList().removeAll();
                        Main.homeScene.getFriendList().setLayout(new GridLayout());
                        Main.homeScene.getFriendList().updateUI();
                        Main.chatScene = null;
                    }


                }
                else {

                }
            } catch (Exception e) {
                if(controlRun){
                    System.out.println("错误在这里");
                    e.printStackTrace();
                }
            }
        }
    }
}