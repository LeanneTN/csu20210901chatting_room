package com.DencendOO.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//该类用于管理服务端的线程集合
public class ManageClientThread {
    private static HashMap<Integer,ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<Integer, ServerConnectClientThread> getHm() {
        return hm;
    }

    //将线程对象添加到hm集合
    public static void addClientThread(int userId, ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }

    //从集合中移除某个线程对象
    public static void removeServerConnectClientThread(int userId){
        hm.remove(userId);
    }


    //根据userId，返回线程
    public static ServerConnectClientThread getServerConnectClientThread(int userId){
        return hm.get(userId);
    }

    //返回在线用户列表
    public static int[] getOnlineUser(){
        //集合遍历
        Iterator<Integer> iterator = hm.keySet().iterator();
        ArrayList<Integer> onlineUsersList = new ArrayList<>();
        while (iterator.hasNext()){
            onlineUsersList.add(iterator.next());
        }

        int[] onlineUserIds = new int[onlineUsersList.size()];
        for(int i = 0;i < onlineUserIds.length;i++){
            onlineUserIds[i] = onlineUsersList.get(i);
        }
        return onlineUserIds;
    }
}
