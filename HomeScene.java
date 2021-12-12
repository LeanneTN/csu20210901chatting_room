/*
 * Created by JFormDesigner on Sat Sep 04 11:35:21 CST 2021
 */

package com.DencendOO.scene;

import com.DencendOO.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import org.jdesktop.swingx.*;

/**
 * @author unknown
 */

public class HomeScene extends JFrame {
    
    class friendModel extends JFrame{
        JButton button;
    }
    
    public HomeScene() {
        initComponents();

        openRoom.setIcon(new ImageIcon("src/com/DencendOO/icon/Chat.png"));
        headPic.setIcon(new ImageIcon("src/com/DencendOO/icon/User.png"));
        addFriend.setIcon(new ImageIcon("src/com/DencendOO/icon/ADD.png"));
        addFriend.setBackground(new Color(0,0,255));
        addFriend.setOpaque(false);
        removeFriend.setIcon(new ImageIcon("src/com/DencendOO/icon/REMOVE.png"));
        //removeFriend.setBorder();
        openRoom.addActionListener(new openRoomListener());
        exit.addActionListener(new exitListener());
        addFriend.addActionListener(new addFriendListener());
        removeFriend.addActionListener(new removeFriendListener());
    }
    
    
    //对于该界面控件的基本初始化
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        addFriend = new JButton();
        removeFriend = new JButton();
        friendListScrollPane = new JScrollPane();
        panel4 = new JPanel();
        panel12 = new JPanel();
        panel13 = new JPanel();
        panel14 = new JPanel();
        panel15 = new JPanel();
        friendList = new JPanel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        panel11 = new JPanel();
        openRoom = new JButton();
        label3 = new JLabel();
        panel3 = new JPanel();
        headPic = new JLabel();
        nicknameLabel = new JLabel();
        stateLabel = new JLabel();
        accountLabel = new JLabel();
        exit = new JButton();
        dress = new JButton();

        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);
        panel4.setOpaque(false);

        //======== this ========
        setMinimumSize(new Dimension(335, 600));
        setTitle("\u4e3b\u9875");
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

            //======== panel1 ========
            {
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
                . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing
                . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
                Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
                ) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
                public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName (
                ) )) throw new RuntimeException( ); }} );

                //---- addFriend ----
                addFriend.setMaximumSize(new Dimension(48, 48));
                addFriend.setMinimumSize(new Dimension(48, 48));
                addFriend.setPreferredSize(new Dimension(48, 48));

                //---- removeFriend ----
                removeFriend.setMaximumSize(new Dimension(48, 48));
                removeFriend.setMinimumSize(new Dimension(48, 48));
                removeFriend.setPreferredSize(new Dimension(48, 48));

                //======== friendListScrollPane ========
                {

                    //======== panel4 ========
                    {
                        panel4.setLayout(new BorderLayout(10, 10));

                        //======== panel12 ========
                        {
                            panel12.setLayout(new GridLayout(1, 1));
                        }
                        panel4.add(panel12, BorderLayout.NORTH);

                        //======== panel13 ========
                        {
                            panel13.setLayout(new GridLayout(1, 1));
                        }
                        panel4.add(panel13, BorderLayout.WEST);

                        //======== panel14 ========
                        {
                            panel14.setLayout(new GridLayout(1, 1));
                        }
                        panel4.add(panel14, BorderLayout.SOUTH);

                        //======== panel15 ========
                        {
                            panel15.setLayout(new GridLayout(1, 1));
                        }
                        panel4.add(panel15, BorderLayout.EAST);

                        //======== friendList ========
                        {
                            friendList.setLayout(new GridLayout());
                        }
                        panel4.add(friendList, BorderLayout.CENTER);
                    }
                    friendListScrollPane.setViewportView(panel4);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(removeFriend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addFriend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(friendListScrollPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(friendListScrollPane, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addFriend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(removeFriend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u79c1\u804a", panel1);

            //======== panel2 ========
            {

                //======== scrollPane1 ========
                {

                    //======== panel5 ========
                    {
                        panel5.setLayout(new BorderLayout(10, 10));

                        //======== panel6 ========
                        {
                            panel6.setLayout(new GridLayout(1, 1));
                        }
                        panel5.add(panel6, BorderLayout.NORTH);

                        //======== panel7 ========
                        {
                            panel7.setLayout(new GridLayout(1, 1));
                        }
                        panel5.add(panel7, BorderLayout.WEST);

                        //======== panel8 ========
                        {
                            panel8.setLayout(new GridLayout(1, 1));
                        }
                        panel5.add(panel8, BorderLayout.SOUTH);

                        //======== panel9 ========
                        {
                            panel9.setLayout(new GridLayout(1, 1));
                        }
                        panel5.add(panel9, BorderLayout.EAST);

                        //======== panel10 ========
                        {
                            panel10.setLayout(new GridLayout(6, 0));

                            //======== panel11 ========
                            {
                                panel11.setLayout(new HorizontalLayout(10));

                                //---- openRoom ----
                                openRoom.setMaximumSize(new Dimension(60, 60));
                                openRoom.setMinimumSize(new Dimension(60, 60));
                                openRoom.setPreferredSize(new Dimension(60, 60));
                                openRoom.setIcon(null);
                                panel11.add(openRoom);

                                //---- label3 ----
                                label3.setText("\u70b9\u51fb\u8fdb\u5165\u804a\u5929\u5ba4\uff01");
                                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                                panel11.add(label3);
                            }
                            panel10.add(panel11);
                        }
                        panel5.add(panel10, BorderLayout.CENTER);
                    }
                    scrollPane1.setViewportView(panel5);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u7fa4\u804a", panel2);
        }

        //======== panel3 ========
        {

            //---- headPic ----
            headPic.setHorizontalAlignment(SwingConstants.CENTER);

            //---- nicknameLabel ----
            nicknameLabel.setText("\u6635\u79f0\uff1aXXX");
            nicknameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

            //---- stateLabel ----
            stateLabel.setText("\u72b6\u6001\uff1a\u3010\u5728\u7ebf\u3011");
            stateLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

            //---- accountLabel ----
            accountLabel.setText("\u8d26\u53f7\uff1aXXX");
            accountLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

            //---- exit ----
            exit.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
            exit.setMaximumSize(new Dimension(40, 40));
            exit.setMinimumSize(new Dimension(40, 40));
            exit.setPreferredSize(new Dimension(40, 40));

            //---- dress ----
            dress.setMaximumSize(new Dimension(40, 40));
            dress.setMinimumSize(new Dimension(40, 40));
            dress.setPreferredSize(new Dimension(40, 40));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(headPic, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nicknameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(dress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(nicknameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountLabel))
                            .addComponent(headPic, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(dress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tabbedPane1))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        URL resource = this.getClass().getResource("BGHome.png"); // 获取背景图片路径
        ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        getContentPane().add(lblBackground); // 将组件添加到面板中
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton addFriend;
    private JButton removeFriend;
    private JScrollPane friendListScrollPane;
    private JPanel panel4;
    private JPanel panel12;
    private JPanel panel13;
    private JPanel panel14;
    private JPanel panel15;
    private JPanel friendList;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JPanel panel11;
    private JButton openRoom;
    private JLabel label3;
    private JPanel panel3;
    private JLabel headPic;
    private JLabel nicknameLabel;
    private JLabel stateLabel;
    private JLabel accountLabel;
    private JButton exit;
    private JButton dress;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JLabel getNicknameLabel(){
        return nicknameLabel;
    }
    public JLabel getAccountLabel(){
        return accountLabel;
    }
    public JPanel getFriendList() {return friendList;}

    //以下代码用于点击群聊时打开界面
    class openRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.roomScene.setVisible(true);
        }
    }
    
    //以下代码用于点击退出时，向服务端发出下线请求
    class exitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.clientSendMessage.logout();
        }
    }

    //以下代码用于点击添加好友按钮触发的操作
    class addFriendListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            AddFriendScene addFriendScene = new AddFriendScene();
            addFriendScene.setVisible(true);
        }
    }

    //以下代码用于点击删除好友按钮触发的操作
    class removeFriendListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            RemoveFriendScene removeFriendScene = new RemoveFriendScene();
            removeFriendScene.setVisible(true);
        }
    }

    //内部类，添加好友的界面
    public class AddFriendScene extends JFrame {
        public AddFriendScene() {
            initComponents();
            okBtn.addActionListener(new okBtnListener());
        }

        private void initComponents() {
            label1 = new JLabel();
            friendId = new JTextField();
            okBtn = new JButton();

            //======== this ========
            setTitle("\u6dfb\u52a0\u597d\u53cb");
            var contentPane = getContentPane();

            //---- label1 ----
            label1.setText("\u8bf7\u8f93\u5165\u60a8\u8981\u6dfb\u52a0\u597d\u53cb\u7684\u8d26\u53f7\uff1a");
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- friendId ----
            friendId.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- okBtn ----
            okBtn.setText("\u786e\u5b9a");
            okBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                    contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(friendId, GroupLayout.Alignment.LEADING)
                                            .addComponent(okBtn)
                                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                    contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(friendId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(okBtn)
                                    .addContainerGap(7, Short.MAX_VALUE))
            );
            pack();
            setLocationRelativeTo(getOwner());
        }

        private JLabel label1;
        private JTextField friendId;
        private JButton okBtn;

        //以下代码用于点击确定按钮触发的操作
        class okBtnListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                String friendIdEntered = friendId.getText();
                if(friendIdEntered.length() == 0){
                    JOptionPane.showMessageDialog(null, "账号不能为空！", "注意：", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try {
                        Main.clientSendMessage.addFriend(Main.clientSendMessage.u,Integer.valueOf(friendIdEntered));
                        closeWindow();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "账号必须为数字！", "注意：", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        public void closeWindow(){this.dispose();}
    }

    //内部类，删除好友的界面
    public class RemoveFriendScene extends JFrame {
        public RemoveFriendScene() {
            initComponents();
            okBtn.addActionListener(new okBtnListener());
        }

        private void initComponents() {
            label1 = new JLabel();
            friendId = new JTextField();
            okBtn = new JButton();

            //======== this ========
            setTitle("\u5220\u9664\u597d\u53cb");
            var contentPane = getContentPane();

            //---- label1 ----
            label1.setText("\u8bf7\u8f93\u5165\u60a8\u8981\u5220\u9664\u597d\u53cb\u7684\u8d26\u53f7\uff1a");
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- friendId ----
            friendId.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- okBtn ----
            okBtn.setText("\u786e\u5b9a");
            okBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                    contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(okBtn)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(friendId)))
                                    .addContainerGap(4, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                    contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(friendId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(okBtn)
                                    .addContainerGap(3, Short.MAX_VALUE))
            );
            pack();
            setLocationRelativeTo(getOwner());
        }

        private JLabel label1;
        private JTextField friendId;
        private JButton okBtn;

        //以下代码用于点击确定按钮触发的操作
        class okBtnListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                String friendIdEntered = friendId.getText();
                if(friendIdEntered.length() == 0){
                    JOptionPane.showMessageDialog(null, "账号不能为空！", "注意：", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try {
                        Main.clientSendMessage.removeFriend(Main.clientSendMessage.u,Integer.valueOf(friendId.getText()));
                        closeWindow();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "账号必须为数字！", "注意：", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        public void closeWindow(){this.dispose();}
    }

    //内部类，单个好友框
//    public static class FriendFrame extends JPanel{
//        private JPanel mainFrame;
//        private JPanel infoFrame;
//        private JButton headPic;
//        private JLabel nicknameLabel;
//        private JLabel userIdLabel;
//
//        public FriendFrame(){
//        }
//        public FriendFrame(String nickname,int userId){
//            mainFrame = new JPanel(new GridLayout(1,2,10,10));
//            infoFrame = new JPanel(new GridLayout(2,1,10,10));
//            headPic = new JButton("开始聊天");
//            mainFrame.add(headPic);
//
//            nicknameLabel = new JLabel("昵称：" + nickname);
//            userIdLabel = new JLabel("账号" + userId);
//            infoFrame.add(nicknameLabel);
//            infoFrame.add(userIdLabel);
//            mainFrame.add(infoFrame);
//        }
//    }

    //好友添加/删除后弹出窗口
    public void addFriendSucceed(){
        JOptionPane.showMessageDialog(null, "添加好友成功！", "成功", JOptionPane.PLAIN_MESSAGE);
    }
    public void addFriendFail(){
        JOptionPane.showMessageDialog(null, "添加好友失败！请检查输入的账号是否正确。", "失败", JOptionPane.ERROR_MESSAGE);
    }
    public void removeFriendSucceed(){
        JOptionPane.showMessageDialog(null, "删除好友成功！", "成功", JOptionPane.PLAIN_MESSAGE);
    }
    public void removeFriendFail(){
        JOptionPane.showMessageDialog(null, "您未添加过该好友！", "失败", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args){
        HomeScene h = new HomeScene();
        h.setVisible(true);
    }
}
