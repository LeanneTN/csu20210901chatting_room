package com.DencendOO.service;

import java.util.HashMap;

//该类用于管理客户端连接服务端的线程
public class ManageClientConnectServerThread {
    //将多个线程放入到HashMap中，key是用户id，value是一个线程
    private static HashMap<Integer,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入hm
    public static void addClientConnectServerThread(int userId,ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }

    //通过userId，得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(int userId){
        return hm.get(userId);
    }

    //将某个线程删除
    public static void removeThread(int userId){
        hm.remove(userId);
    }

}
