package com.DencendOO.service;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

public class DatabaseOperate {
    //用户注册，将信息插入信息库userMessage表中
    public static void insert (String nickName,int account,String password)
            throws SQLException {
        //1、注册驱动
        Driver driver = new Driver();
        //2、得到连接
        String url = "jdbc:mysql://localhost:3306/data";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = driver.connect(url,properties);
        //3、执行sql
        String sql = "insert into userMessage values ('"+nickName+"',"+account+",'"+password+"','')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //关闭连接资源
        statement.close();;
        connection.close();
    }

//    //用户注册，检查昵称是已否存在,不存在为0，存在为1
//    public static boolean selectNickName (String nickName)
//                        throws SQLException{
//        //此处写法为：new com.mysql.cj.jdbc.Driver().var;
//        Driver driver = new Driver();
//        String url = "jdbc:mysql://localhost:3306/data";
//        Properties properties = new Properties();
//        properties.setProperty("user","root");
//        properties.setProperty("password","123456");
//        Connection connection = driver.connect(url,properties);
//        Statement statement = connection.createStatement();
//        String sql = "select nickName from userMessage";
//        ResultSet resultSet = statement.executeQuery(sql);
//        //遍历表格，得到信息
//        while(resultSet.next()){
//            String getName = resultSet.getString(1);//第二列，vrchar转为String
//            //输出信息
//            if(getName.equals(nickName)){
//                resultSet.close();             //多关闭一个
//                statement.close();;
//                connection.close();
//                return true;
//            }
//        }
//
//        resultSet.close();             //多关闭一个
//        statement.close();;
//        connection.close();
//
//        return false;
//    }

    //用户注册，检查账户是否已存在,不存在为false，存在为true
    public static boolean selectAccount (int account)
            throws SQLException{
        //此处写法为：new com.mysql.cj.jdbc.Driver().var;
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/data";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = driver.connect(url,properties);
        Statement statement = connection.createStatement();
        String sql = "select account from userMessage";
        ResultSet resultSet = statement.executeQuery(sql);
        //遍历表格，得到信息
        while(resultSet.next()){
            int getAccount = resultSet.getInt(1);//就一个，算一列
            //输出信息
            if(getAccount == account){
                resultSet.close();             //多关闭一个
                statement.close();;
                connection.close();
                return true;
            }
        }

        resultSet.close();             //多关闭一个
        statement.close();;
        connection.close();

        return false;
    }

    //登陆时在确认账户已存在的前提下验证密码是否正确
    public static boolean selectLogin (int account,String password)
            throws SQLException{
        //此处写法为：new com.mysql.cj.jdbc.Driver().var;
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/data";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = driver.connect(url,properties);
        Statement statement = connection.createStatement();
        String sql = "select account,password from userMessage";
        ResultSet resultSet = statement.executeQuery(sql);
        //遍历表格，得到信息
        while(resultSet.next()){
            int getAccount = resultSet.getInt(1);//第一列，vrchar转为String
            //账户存在
            if(getAccount == account ){
                String getPassword =resultSet.getString(2);
                if(getPassword.equals(password))   //密码对应正确
                {
                    resultSet.close();             //多关闭一个
                    statement.close();;
                    connection.close();
                    return true;
                }
            }
        }

        resultSet.close();             //多关闭一个
        statement.close();;
        connection.close();

        return false;
    }

    //(使用该函数前先调用上方selectAccount函数，判断friendId是否在数据库内)
    // （此处默认在数据库内）检查好友数据,查看是否已经加过了某人,加过了返回false，没加过则进行添加，返回true
    public static boolean addFriends(int userId,int friendId) throws ClassNotFoundException, SQLException {
        if(friendId==userId){
            return false;
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/data";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,user,password);
        String sql = "select account,friends from userMessage";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            if ((userId == resultSet.getInt(1)))  //找到用户
            {
                //首先找到friends中储存的#的个数，从而判断已经有了几个朋友
                String friendsMessage = resultSet.getString(2);  //获取数据库中的好友信息
                String newFriendId1= Integer.toString(friendId)+"#";       //用于检验是否存在该好友
                String newFriendId2 = "#"+Integer.toString(friendId)+"#";
                boolean isExit=true;      //记录是否已经加了该好友，默认为存在
                boolean isFirst =true;
                if(friendsMessage.length()<newFriendId1.length()){
                    isExit = false;
                    isFirst =false;
                    System.out.println("长度小于！！！！！");
                }
                else {
                    for(int i=0;i<newFriendId1.length();i++){
                        if(friendsMessage.charAt(i)!=newFriendId1.charAt(i)){  //一旦不相等，该好友就不会是第一个
                            isFirst = false;
                            System.out.println("不是第一个!!!!");
                        }
                    }
                    if((!friendsMessage.contains(newFriendId2))&&(!isFirst)){ //验证该好友是不是在后面
                        isExit =false;
                        System.out.println("不存在！！！！！");
                    }
                }
//                if(!friendsMessage.contains(newFriendId2)){//初步验证
//                    if(friendsMessage.equals(newFriendId1)){
//                        isFirst=true;
//                    }
//                    else{
//                        isExit = false;
//                    }
////                if(!friendsMessage.contains(newFriendId2)){//初步验证
////                    for(int i=0;i<newFriendId1.length();i++){
////                        if(friendsMessage.charAt(i)!=newFriendId1.charAt(i)){
////                            isExit = false;
////                        }
////                    }
//                }
                if(!isExit){//该用户不在好友列表
                    String newfriendsMessage = friendsMessage+newFriendId1;
                    String addSql = "update userMessage set friends = '"+newfriendsMessage+"' where account = "+userId+" ";
                    //System.out.println("好友信息"+friendMessage);
                    Statement addStatement = connection.createStatement();
                    statement.executeUpdate(addSql);
                    addStatement.close();

                    resultSet.close();             //多关闭一个
                    statement.close();;
                    connection.close();
                    return true;
                }
                else {//该用户已在好友列表
                    resultSet.close();             //多关闭一个
                    statement.close();;
                    connection.close();
                    return false;
                }
            }
        }
        resultSet.close();;
        statement.close();
        connection.close();
        return false;
    }

    //(使用该函数前先调用上方selectAccount函数，判断friendId是否在数据库内)
    //（此处默认已经在数据库内）删除好友，没有加过这个好友，返回false；若加过，删除后返回true
    public static boolean deleteFriends(int userId,int friendId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/data";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,user,password);
        String sql = "select account,friends from userMessage";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            if ((userId == resultSet.getInt(1)))  //找到用户
            {
                //首先找到friends中储存的#的个数，从而判断已经有了几个朋友
                String friendsMessage = resultSet.getString(2);  //获取数据库中的好友信息
                String newFriendId1= Integer.toString(friendId)+"#";       //用于检验是否存在该好友
                String newFriendId2 = "#"+Integer.toString(friendId)+"#";
                boolean isExit=true;      //记录是否已经加了该好友，默认为存在
                boolean isFirst=true;    //判断该好友是否在第一个位置，默认为true
                if(friendsMessage.length()<newFriendId1.length()){
                    isExit = false;
                    isFirst =false;
                    System.out.println("长度小于！！！！！");
                }
                else {
                    for(int i=0;i<newFriendId1.length();i++){
                        if(friendsMessage.charAt(i)!=newFriendId1.charAt(i)){  //一旦不相等，该好友就不会是第一个
                            isFirst = false;
                            System.out.println("不是第一个!!!!");
                        }
                    }
                    if((!friendsMessage.contains(newFriendId2))&&(!isFirst)){ //验证该好友是不是在后面
                        isExit =false;
                        System.out.println("不存在！！！！！");
                    }
                }
//                if(!friendsMessage.contains(newFriendId2)){//初步验证
//                    if(friendsMessage.equals(newFriendId1)){
//                        isFirst=true;
//                    }
//                    else{
//                        isExit = false;
//                    }
//                    for(int i=0;i<newFriendId1.length();i++){
//                        if(friendsMessage.charAt(i)!=newFriendId1.charAt(i)){
//                            isExit = false;
//                        }
//                    }
//                    if(isExit==true){
//                        isFirst =true;
//                    }
//                }
                if(isExit){//该用户在好友列表
                    //判断该用户是不是在第一个位置
                    String newfriendsMessage;
                    if(isFirst){//该用户在第一个位置
                        newfriendsMessage = friendsMessage.replaceFirst(newFriendId1,"");
                    }else{
                        newfriendsMessage = friendsMessage.replaceFirst(newFriendId2,"#");
                    }
                    String addSql = "update userMessage set friends = '"+newfriendsMessage+"' where account = "+userId+" ";
                    //System.out.println("好友信息"+friendMessage);
                    Statement addStatement = connection.createStatement();
                    statement.executeUpdate(addSql);
                    addStatement.close();

                    resultSet.close();             //多关闭一个
                    statement.close();;
                    connection.close();
                    return true;
                }
                else {//该用户不在好友列表
                    resultSet.close();             //多关闭一个
                    statement.close();;
                    connection.close();
                    return false;
                }
            }
        }
        resultSet.close();;
        statement.close();
        connection.close();
        return false;
    }

    //由账号获得昵称
    public static String getNickName(int account) throws ClassNotFoundException, SQLException {
        String nickName = null;       //返回值
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/data";
        String user = "root";
        String password = "123456";
        Connection connection =DriverManager.getConnection(url,user,password);
        String sql = "select account,nickName from userMessage";
        Statement statement = connection.createStatement();
        ResultSet resultSet =statement.executeQuery(sql);
        while(resultSet.next()){
            if(resultSet.getInt(1)==account){//
                nickName = resultSet.getString(2);
            }
        }
        resultSet.close();;
        statement.close();
        connection.close();

        return nickName;
    }

    //由账号获得好友（对好友信息进行拆分，转化为数组返回）
    public static int [] getFriends(int account) throws ClassNotFoundException, SQLException {
        String friendsMessage = null;
        int []arr;         //返回数组
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/data";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select account,friends from userMessage";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            if(resultSet.getInt(1)==account) //找到该用户
            {
                friendsMessage = resultSet.getString(2);
                if(friendsMessage.equals("")){
                    resultSet.close();;
                    statement.close();
                    connection.close();
                    return null;
                }
                String []strings = friendsMessage.split("#");
                int length = strings.length;
                arr = new int[length];
                for(int i=0;i<length;i++)
                {
                    arr[i] = Integer.parseInt(strings[i]);
                }

                resultSet.close();;
                statement.close();
                connection.close();
                return arr;
            }
        }

        resultSet.close();;
        statement.close();
        connection.close();
        return null;
    }
}