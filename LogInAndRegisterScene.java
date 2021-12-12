/*
 * Created by JFormDesigner on Thu Sep 02 13:20:16 CST 2021
 */

package com.DencendOO.scene;

import com.DencendOO.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 * @author unknown
 */
public class LogInAndRegisterScene extends JFrame {
    public LogInAndRegisterScene() {
        initComponents();
        //监听按钮：
        ButtonActionListener1 actionListener1 = new ButtonActionListener1();
        ButtonActionListener2 actionListener2 = new ButtonActionListener2();
        //监听登录按钮
        logIn.addActionListener(actionListener1);
        //监听注册按钮
        register.addActionListener(actionListener2);
    }

    //完成组件的创建/大小/字体/位置等基本设置
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        UIManager.put("TabbedPane.contentOpaque", false);

        mainFrame = new JTabbedPane();
        logInFrame = new JPanel();
        idLabel = new JLabel();
        pwdLabel = new JLabel();
        userId = new JTextField();
        titleLabel = new JLabel();
        logIn = new JButton();
        vSpacer1 = new JPanel(null);
        password = new JPasswordField();
        registerFrame = new JPanel();
        register = new JButton();
        hSpacer1 = new JPanel(null);
        pwd = new JPasswordField();
        pwdConfirm = new JPasswordField();
        account = new JTextField();
        nickname = new JTextField();
        pwdLabel1 = new JLabel();
        idLabel1 = new JLabel();
        confirmLabel = new JLabel();
        nicknameLabel = new JLabel();

        //设置透明度
        logInFrame.setOpaque(false);
        mainFrame.setOpaque(false);
        registerFrame.setOpaque(false);


        //======== this ========
        setTitle("DencendOO");
        var contentPane = getContentPane();

        //======== mainFrame ========
        {
            mainFrame.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //======== logInFrame ========
            {
                //---- idLabel ----
                idLabel.setText("\u8d26\u53f7\uff1a");
                idLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                idLabel.setMaximumSize(new Dimension(48, 32));
                idLabel.setMinimumSize(new Dimension(48, 32));
                idLabel.setPreferredSize(new Dimension(48, 32));

                //---- pwdLabel ----
                pwdLabel.setText("\u5bc6\u7801\uff1a");
                pwdLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                pwdLabel.setMaximumSize(new Dimension(48, 32));
                pwdLabel.setMinimumSize(new Dimension(48, 32));
                pwdLabel.setPreferredSize(new Dimension(48, 32));

                //---- userId ----
                userId.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                userId.setMaximumSize(new Dimension(1000, 32));
                userId.setMinimumSize(new Dimension(200, 32));
                userId.setPreferredSize(new Dimension(200, 32));

                //---- titleLabel ----
                titleLabel.setText("\u6b22\u8fce\u4f7f\u7528\u817e\u900aOO");
                titleLabel.setFont(new Font("\u534e\u6587\u7425\u73c0", Font.PLAIN, 20));

                //---- logIn ----
                logIn.setText("\u767b\u5f55");
                logIn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                logIn.setMaximumSize(new Dimension(72, 36));
                logIn.setMinimumSize(new Dimension(72, 36));
                logIn.setPreferredSize(new Dimension(72, 36));

                //---- password ----
                password.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
                password.setMinimumSize(new Dimension(49, 32));
                password.setPreferredSize(new Dimension(49, 32));

                GroupLayout logInFrameLayout = new GroupLayout(logInFrame);
                logInFrame.setLayout(logInFrameLayout);
                logInFrameLayout.setHorizontalGroup(
                    logInFrameLayout.createParallelGroup()
                        .addGroup(logInFrameLayout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(95, Short.MAX_VALUE))
                        .addGroup(logInFrameLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(pwdLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(userId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, logInFrameLayout.createSequentialGroup()
                                    .addComponent(vSpacer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(logIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 72, Short.MAX_VALUE))
                );
                logInFrameLayout.setVerticalGroup(
                    logInFrameLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, logInFrameLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(userId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(pwdLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(password, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(logInFrameLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(logIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(vSpacer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17))
                );
            }
            mainFrame.addTab("\u767b\u5f55", logInFrame);

            //======== registerFrame ========
            {

                //---- register ----
                register.setText("\u6ce8\u518c");
                register.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                register.setMaximumSize(new Dimension(72, 36));
                register.setMinimumSize(new Dimension(72, 36));
                register.setPreferredSize(new Dimension(72, 36));

                //---- pwd ----
                pwd.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
                pwd.setMinimumSize(new Dimension(49, 32));
                pwd.setPreferredSize(new Dimension(49, 32));

                //---- pwdConfirm ----
                pwdConfirm.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
                pwdConfirm.setMinimumSize(new Dimension(49, 32));
                pwdConfirm.setPreferredSize(new Dimension(49, 32));

                //---- account ----
                account.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- nickname ----
                nickname.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- pwdLabel1 ----
                pwdLabel1.setText("\u5bc6\u7801\uff1a");
                pwdLabel1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                pwdLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
                pwdLabel1.setMaximumSize(new Dimension(48, 32));
                pwdLabel1.setMinimumSize(new Dimension(48, 32));
                pwdLabel1.setPreferredSize(new Dimension(48, 32));

                //---- idLabel1 ----
                idLabel1.setText("\u8d26\u53f7\uff1a");
                idLabel1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                idLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
                idLabel1.setMaximumSize(new Dimension(48, 32));
                idLabel1.setMinimumSize(new Dimension(48, 32));
                idLabel1.setPreferredSize(new Dimension(48, 32));

                //---- confirmLabel ----
                confirmLabel.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
                confirmLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                confirmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                confirmLabel.setMaximumSize(new Dimension(80, 32));
                confirmLabel.setMinimumSize(new Dimension(80, 32));
                confirmLabel.setPreferredSize(new Dimension(80, 32));

                //---- nicknameLabel ----
                nicknameLabel.setText("\u6635\u79f0\uff1a");
                nicknameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                nicknameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                nicknameLabel.setMaximumSize(new Dimension(48, 32));
                nicknameLabel.setMinimumSize(new Dimension(48, 32));
                nicknameLabel.setPreferredSize(new Dimension(48, 32));

                GroupLayout registerFrameLayout = new GroupLayout(registerFrame);
                registerFrame.setLayout(registerFrameLayout);
                registerFrameLayout.setHorizontalGroup(
                    registerFrameLayout.createParallelGroup()
                        .addGroup(registerFrameLayout.createSequentialGroup()
                            .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(registerFrameLayout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pwdLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(idLabel1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(confirmLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(nicknameLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(pwdConfirm, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(account)
                                        .addComponent(nickname, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(pwd, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                    .addGap(0, 9, Short.MAX_VALUE))
                                .addGroup(registerFrameLayout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(hSpacer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(register, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6))
                );
                registerFrameLayout.setVerticalGroup(
                    registerFrameLayout.createParallelGroup()
                        .addGroup(registerFrameLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(nickname)
                                .addComponent(nicknameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(8, 8, 8)
                            .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(idLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(account))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(registerFrameLayout.createParallelGroup()
                                .addComponent(pwdLabel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pwd, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(pwdConfirm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(12, 12, 12)
                            .addGroup(registerFrameLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(register, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(hSpacer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7))
                );
            }
            mainFrame.addTab("\u6ce8\u518c", registerFrame);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainFrame)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainFrame, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        URL resource = this.getClass().getResource("LAR.jpg"); // 获取背景图片路径
        ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        getContentPane().add(lblBackground); // 将组件添加到面板中
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTabbedPane mainFrame;

    //登录界面
    //标签和弹簧
    private JPanel logInFrame;
    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel pwdLabel;
    private JPanel vSpacer1;
    //文本框和按钮
    private JTextField userId;//账号
    private JPasswordField password;//密码
    private JButton logIn;//登录按钮

    //注册界面
    //标签和弹簧
    private JPanel registerFrame;
    private JLabel idLabel1;
    private JLabel nicknameLabel;
    private JLabel pwdLabel1;
    private JLabel confirmLabel;
    private JPanel hSpacer1;
    //文本框和按钮
    private JTextField account;//账号
    private JTextField nickname;//昵称
    private JPasswordField pwd;//密码
    private JPasswordField pwdConfirm;//确认密码
    private JButton register;//注册按钮

    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //以下是按下登录按钮时的处理
    private class ButtonActionListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取输入的用户名和密码
            int userIdEntered = Integer.valueOf(userId.getText());
            String passwordEntered = password.getText();
            System.out.println("用户输入了用户名："+userIdEntered + " 密码："+passwordEntered);
            if(Main.clientSendMessage.isLogIn(userIdEntered,passwordEntered))
            {
                //关闭当前页面
                closeWindow();
            }
            else
            {
                //提示用户检查账号和密码
                JOptionPane.showMessageDialog(null, "请检查账号或者密码！", "用户不存在", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //以下是按下注册按钮时的处理
    private class ButtonActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            react();
        }

        //该变量用于标记注册是否成功
        boolean flag;

        //判断账户是否为空
        public boolean tellAccount() {
            String accountText = account.getText();
            if (accountText.length() == 0)
                return true;
            else
                return false;
        }

        //判断昵称是否为空
        public boolean tellName() {
            String nicknameText = nickname.getText();
            if (nicknameText.length() == 0)
                return true;
            else
                return false;
        }

        //判断密码是否为空
        public boolean tellPassword(){
            String pwdText = pwd.getText();
            if (pwdText.length() == 0)
                return true;
            else
                return false;
        }

        //判断密码长度
        public boolean tellPasswordLength(){
            String pwdText = new String(pwd.getPassword());
            if ((pwdText.length() < 6) && (pwdText.length() != 0)) {
                return true;
            }
            else{
                return false;
            }
        }

        //检查验证密码是否为空
        public boolean confirmPassowrd() {
            String pwdConfirmText = pwdConfirm.getText();
            if (pwdConfirmText.length() == 0)
                return true;
            else
                return false;
        }

        //验证两次密码是否相同
        public boolean isPasswordSame(){
            String pwdTest = pwd.getText();
            String pwdConfirmText = pwdConfirm.getText();
            if(pwdTest.equals(pwdConfirmText))
                return true;
            else
                return false;
        }

        //像服务端请求注册
        public void requestRegister(){
            flag = Main.clientSendMessage.isUserIdExist(Integer.valueOf(account.getText()),pwd.getText(),nickname.getText());
        }

        //根据用户输入弹出提示
        public void react() {
            if (tellName()) {
                JOptionPane.showMessageDialog(null, "昵称不得为空！", "注意：", JOptionPane.ERROR_MESSAGE);
            } else if (tellAccount()) {
                JOptionPane.showMessageDialog(null, "账号不得为空！", "注意：", JOptionPane.ERROR_MESSAGE);
            } else if (tellPassword()) {
                JOptionPane.showMessageDialog(null, "密码不得为空！", "注意：", JOptionPane.ERROR_MESSAGE);
            } else if (confirmPassowrd()) {
                JOptionPane.showMessageDialog(null, "验证密码不得为空！", "注意：", JOptionPane.ERROR_MESSAGE);
            } else if (tellPasswordLength()) {
                JOptionPane.showMessageDialog(null, "密码至少为六位！", "注意:", JOptionPane.ERROR_MESSAGE);
            } else if (!isPasswordSame()) {
                JOptionPane.showMessageDialog(null, "两次输入的密码不同！", "注意：", JOptionPane.ERROR_MESSAGE);
            } else{
                requestRegister();
                if(flag)
                    JOptionPane.showMessageDialog(null, "该账户已被占用！", "注意：", JOptionPane.ERROR_MESSAGE);
                else if(!flag) {
                    JOptionPane.showMessageDialog(null, "注册成功", "提示：", JOptionPane.PLAIN_MESSAGE);
                    mainFrame.setSelectedIndex(0);
                    userId.setText(account.getText());
                    password.setText("");

                    nickname.setText("");
                    account.setText("");
                    pwd.setText("");
                    pwdConfirm.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "发生未知错误！", "注意：", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void closeWindow(){
        this.dispose();
    }

    public static void main(String[] args){
        LogInAndRegisterScene l = new LogInAndRegisterScene();
        l.setVisible(true);
    }
}
