package com.DencendOO.common;

import java.io.Serializable;

public class Message implements Serializable {
    public static final long serialVersionUID = 1L;//增强兼容性
    private User sender;//消息的发送者
    private User getter;//接收者
    private String content;//消息内容
    private String messageType;//消息类型
    private String sendTime;//发送时间

    private int[] friendIds;
    private User[] usersList;

    //Getter
    public User getSender() {
        return sender;
    }
    public User getGetter() {
        return getter;
    }
    public String getContent() {
        return content;
    }
    public String getMessageType() {
        return messageType;
    }
    public String getSendTime() {
        return sendTime;
    }
    public int[] getFriendIds() {
        return friendIds;
    }
    public User[] getUsersList() {
        return usersList;
    }

    //Setter
    public void setSender(User sender) {
        this.sender = sender;
    }
    public void setGetter(User getter) {
        this.getter = getter;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
    public void setFriendIds(int[] friendIds) {
        this.friendIds = friendIds;
    }
    public void setUsersList(User[] usersList) {
        this.usersList = usersList;
    }
}
