/*
 * Created by JFormDesigner on Thu Sep 02 15:18:50 CST 2021
 */

package com.DencendOO.scene;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class ServerScene extends JFrame {
    public ServerScene() {
        initComponents();
    }

    //组件的创建/大小/位置/字体等基本设置
    private void initComponents() {
        setTitle("DencendOO Server");
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ipLabel = new JLabel();
        portLabel = new JLabel();
        IP = new JTextField();
        Pot = new JTextField();
        recodLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        record = new JEditorPane();

        //======== this ========
        setMinimumSize(new Dimension(430, 450));
        var contentPane = getContentPane();

        //---- ipLabel ----
        ipLabel.setText("IP\uff1a");
        ipLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //---- portLabel ----
        portLabel.setText("Port\uff1a");
        portLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //---- IP ----
        IP.setMinimumSize(new Dimension(300, 30));
        IP.setPreferredSize(new Dimension(300, 30));
        IP.setEditable(false);
        IP.setText("127.0.0.1");
        IP.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //---- Pot ----
        Pot.setMinimumSize(new Dimension(300, 30));
        Pot.setPreferredSize(new Dimension(300, 30));
        Pot.setMaximumSize(new Dimension(300, 2147483647));
        Pot.setEditable(false);
        Pot.setText("9999");
        Pot.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //---- recodLabel ----
        recodLabel.setText("\u6d88\u606f\u8bb0\u5f55\uff1a");
        recodLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //======== scrollPane1 ========
        {

            //---- record ----
            record.setMinimumSize(new Dimension(300, 300));
            record.setPreferredSize(new Dimension(300, 300));
            record.setMaximumSize(new Dimension(300, 2147483647));
            record.setEditable(false);
            scrollPane1.setViewportView(record);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(recodLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(portLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(IP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Pot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(IP, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ipLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Pot, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(portLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(recodLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown

    //界面的标签和滚动条
    private JLabel ipLabel;
    private JLabel portLabel;
    private JLabel recodLabel;
    private JScrollPane scrollPane1;

    //界面的文本框
    private JTextField IP;//服务端的IP
    private JTextField Pot;//监听的端口
    private JEditorPane record;//聊天记录框

    // JFormDesigner - End of variables declaration  //GEN-END:variables

//    public static void main(String[] args) {
//        ServerScene serverScene = new ServerScene();
//        serverScene.setVisible(true);
//        serverScene.setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
}
