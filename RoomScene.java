/*
 * Created by JFormDesigner on Sat Sep 04 11:36:00 CST 2021
 */

package com.DencendOO.scene;

import com.DencendOO.Main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author unknown
 */
public class RoomScene extends JFrame {

    private ArrayList<String> location = new ArrayList<>();


    public RoomScene() {
        initComponents();

        setTitle("聊天室");

        //按钮监听
        sendBtn.addActionListener(new SendBtnListener());

        fileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(); // 设置选择器
                chooser.setMultiSelectionEnabled(false); // 设为多选
                int returnVal = chooser.showOpenDialog(fileBtn); // 是否打开文件选择框
                System.out.println("returnVal=" + returnVal);

                if (returnVal == JFileChooser.APPROVE_OPTION) { // 如果符合文件类型

                    String filepath = chooser.getSelectedFile().getAbsolutePath(); // 获取绝对路径
                    System.out.println(filepath);

                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName()); // 输出相对路径

                }
            }
        });

        emojiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageArea.getText();
                String oldInfo = screen.getText();
                for(int i = 0; i < location.size(); i++) {
                    Icon img = new ImageIcon(location.get(i));
                    System.out.println("img: "+img.toString());
                    screen.insertIcon(new ImageIcon(PicsJWindow.class.getResource(location.get(i))));
                }
                location.clear();
                messageArea.setText("");

            }
        });

    }

    //对组件的大小、位置等基本设置
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        screen = new JTextPane();
        scrollPane2 = new JScrollPane();
        messageArea = new JTextPane();
        sendBtn = new JButton();
        emojiBtn = new JButton();
        fileBtn = new JButton();
        scrollPane3 = new JScrollPane();
        onlineUsers = new JList();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- screen ----
            screen.setEditable(false);
            scrollPane1.setViewportView(screen);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(messageArea);
        }

        //---- sendBtn ----
        sendBtn.setText("\u53d1\u9001");

        //---- emojiBtn ----
        emojiBtn.setText("\u8868\u60c5");

        //---- fileBtn ----
        fileBtn.setText("\u6587\u4ef6");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(onlineUsers);
        }

        //---- label1 ----
        label1.setText("\u5728\u7ebf\u7528\u6237\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(sendBtn)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(emojiBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileBtn))
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addContainerGap(58, Short.MAX_VALUE))
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(emojiBtn)
                                .addComponent(fileBtn))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane3)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sendBtn)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTextPane screen;
    private JScrollPane scrollPane2;
    private JTextPane messageArea;
    private JButton sendBtn;
    private JButton emojiBtn;
    private JButton fileBtn;
    private JScrollPane scrollPane3;
    private JList onlineUsers;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JTextPane getScreen() {
        return screen;
    }
    public JList getOnlineUsers() {
        return onlineUsers;
    }

    public void setTextInScreen(String text){
        screen.setText(text);
    }

    public JButton  getEmojiBtn() {
        return emojiBtn;
    }


    //按下发送按钮后的处理
    class SendBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.clientSendMessage.sendMessageToAll(messageArea.getText(), Main.clientSendMessage.u);
            messageArea.setText("");

//            String message = messageArea.getText();
//            String oldInfo = screen.getText();
//            if(oldInfo.length()==0){
//                String information = ">>> " + message;
//                screen.setText(information);
//            }
//            else {
//                String information = oldInfo + '\n' + ">>> " + message;
//                screen.setText(information);
//            }
//            messageArea.setText("");
//
//
//
//            String content = messageArea.getText() + "\n";
//            String senderId = LogInAndRegisterScene.userClientService.u.getUserId();
//            String getterId = (String) selectObj.getItemAt(selectObj.getSelectedIndex());
//            messageClientService.sendMessageToOne(content,senderId,getterId);
//
//            String oldInfo = screen.getText();
//            if(oldInfo.length()==0){
//                String information = ">>> " + content;
//                screen.setText(information);
//            }
//            else {
//                String information = oldInfo + '\n' + ">>> " + content;
//                screen.setText(information);
//            }
//            messageArea.setText("");
        }
    }

    public void insertSendPic(ImageIcon img, String path){
        location.add(path);
        System.out.println("path:"+path);
        messageArea.insertIcon(img);
        System.out.print(img.toString()); //终端输出信息检验是否插入的是正确的表情
    }


    public static void main(String[] args){
        RoomScene r = new RoomScene();
        r.setVisible(true);
    }
}
