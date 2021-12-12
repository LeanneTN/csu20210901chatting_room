/*
 * Created by JFormDesigner on Sat Sep 04 11:36:41 CST 2021
 */

package com.DencendOO.scene;

import com.DencendOO.Main;
import com.DencendOO.common.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author unknown
 */
public class ChatScene extends JFrame {
    public ChatScene(int friendId,String friendNickname) {
        this.friendId = friendId;
        this.friendNickname = friendNickname;
        initComponents();

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
    }

    //对于组件的基本初始化，包括组件大小、位置等
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        screen = new JTextPane();
        emojiBtn = new JButton();
        fileBtn = new JButton();
        scrollPane2 = new JScrollPane();
        messageArea = new JTextPane();
        sendBtn = new JButton();

        //======== this ========
        setTitle("FridenNickname");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- screen ----
            screen.setEditable(false);
            scrollPane1.setViewportView(screen);
        }

        //---- emojiBtn ----
        emojiBtn.setText("\u8868\u60c5");

        //---- fileBtn ----
        fileBtn.setText("\u6587\u4ef6");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(messageArea);
        }

        //---- sendBtn ----
        sendBtn.setText("\u53d1\u9001");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(emojiBtn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fileBtn)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 348, Short.MAX_VALUE)
                            .addComponent(sendBtn))
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(emojiBtn)
                        .addComponent(fileBtn))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendBtn)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTextPane screen;
    private JButton emojiBtn;
    private JButton fileBtn;
    private JScrollPane scrollPane2;
    private JTextPane messageArea;
    private JButton sendBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    private int friendId;
    private String friendNickname;

    //一些Getter
    public int getFriendId() {
        return friendId;
    }
    public String getFriendNickname() {
        return friendNickname;
    }
    public JTextPane getScreen() {
        return screen;
    }
    public JTextPane getMessageArea() {
        return messageArea;
    }

    //按下发送按钮后的处理
    class SendBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User getter = new User();
            getter.setUserId(friendId);
            getter.setNickname(friendNickname);

            String oldContent = screen.getText();
//            String clientMes = Main.clientSendMessage.u.getNickname() + "说：\n" + messageArea.getText() + "\n\n";
            String clientMes = "你说：\n" + messageArea.getText() + "\n\n";
            screen.setText(oldContent + clientMes);

            Main.clientSendMessage.sendMessageToOne(messageArea.getText(),Main.clientSendMessage.u,getter);
            messageArea.setText("");
        }
    }
}
