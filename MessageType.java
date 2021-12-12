package com.DencendOO.common;

public interface MessageType {
    //在接口中定义一些常量，常量不同的值代表不同的消息类型

    //以下是客户端发给服务端（服务端接收）的消息类型
    String MESSAGE_LOGIN = "1";//用户申请登录
    String MESSAGE_REGISTER = "2";//用户申请注册
    String MESSAGE_GET_ONLINE_FRIEND = "3";//获取当前在线的用户
    String MESSAGE_CLIENT_EXIT = "4";//客户端请求退出
    String MESSAGE_COMM_MES = "5";//普通信息包(私聊)
    String MESSAGE_GROUP_MES = "6";//群发消息
    String MESSAGE_ADD_FRIEND = "7";
    String MESSAGE_REMOVE_FRIEND = "8";
    String MESSAGE_GET_ALL_FRIEND = "9";//获取自己的好友
    String MESSAGE_GET_NICKNAME_BY_USERID = "10";

    //以下是服务端发给客户端（客户端接收）的消息类型
    String MESSAGE_LOGIN_SUCCEED = "11";//登录成功
    String MESSAGE_LOGIN_FAIL = "12";//登录失败
    String MESSAGE_REGISTER_SUCCEED = "13";//注册成功
    String MESSAGE_REGISTER_FAIL = "14";//注册失败
    String MESSAGE_UID_EXIST = "15";//账号被占用
    String MESSAGE_RETURN_ONLINE_FRIEND = "16";//返回当前在线的用户
    String MESSAGE_ADD_FRIEND_SUCCEED = "17";//成功添加好友
    String MESSAGE_ADD_FRIEND_FAIL = "18";//添加好友失败
    String MESSAGE_REMOVE_FRIEND_SUCCEED = "19";//删除好友成功
    String MESSAGE_REMOVE_FRIEND_FAIL = "20";//添加好友失败
    String MESSAGE_NEW_LOGIN = "21";//有新用户登录
    String MESSAGE_NEW_LOGOUT = "22";//有用户下线
    String MESSAGE_CLIENT_FRIENDS = "23";//返回用户的好友
}
