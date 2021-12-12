package com.DencendOO.common;

import java.io.Serializable;

public class User implements Serializable {
    public static final long serialVersionUID = 1L;//增强兼容性
    private int userId;
    private String nickname;
    private String password;
    private String friends;

    //构造方法
    public User(){}
    public User(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public User(int userId, String password,String nickname){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }

    //Getter
    public int getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {return nickname;}

    //Setter
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNickname(String nickname) {this.nickname = nickname;}
}
