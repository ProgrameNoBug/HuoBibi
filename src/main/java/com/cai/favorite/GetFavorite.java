package com.cai.favorite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GetFavorite {
    static Connection con;
    static Statement sql;
    static ResultSet res;

    public Connection Connection() {
        // TODO Auto-generated method stub
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/favorite?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
        String name = "root";
        String code = "123456";

        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, name, code);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    public List<String> Get()  {
        GetFavorite c=new GetFavorite();
        List<String>list = new ArrayList<String>();
        con=c.Connection();
        try {
            String sea = "select * from favorite order by id DESC";
            sql=con.createStatement();
            res=sql.executeQuery(sea);
            int productID;
            String title,price,pic,url;
            //System.out.println("id\t title\t price\t pic\t url");
            while(res.next()){
                productID=res.getInt("productID");
                title=res.getString("title");
                price=res.getString("price");
                url=res.getString("url");
                pic=res.getString("pic");
                System.out.println(productID+"\t"+title+"\t"+price+"\t"+pic+"\t"+url);//输出查询结果
                list.add(productID+"\t"+title+"\t"+price+"\t"+pic+"\t"+url);
            }
            return list;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Get();
    }
    public static void main(String[] args) {
        GetFavorite b =new GetFavorite();
        List<String> value = b.Get();
        System.out.println(value);
    }
}