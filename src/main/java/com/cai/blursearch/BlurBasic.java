package com.cai.blursearch;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cai.login_register.MysqlTool;
public class BlurBasic {
	static Connection con;
    static Statement sql;
    static ResultSet res;

    public Connection Connection() {
        // TODO Auto-generated method stub
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/202?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
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

   

    
	public List<String> search(String str)  {
		BlurBasic c=new BlurBasic();
		List<String>list = new ArrayList<String>();
		con=c.Connection();
		try {
			String sea;
			sea = "select * from jd_item where title like '%"+str+"%'";
			sql=con.createStatement();
			res=sql.executeQuery(sea);
			int id;
			String url,name,pic,price;
	        //System.out.println("id\t title\t price\t pic\t url");
	      while(res.next()){
	        id=res.getInt("id");
	        name=res.getString("title");
	        price=res.getString("price");
	        url=res.getString("url");
	        pic=res.getString("pic");
	        //System.out.println(id+"\t"+name+"\t"+price+"\t"+pic+"\t"+url);//??????ѯ????
	        list.add(id+"\t"+name+"\t"+price+"\t"+pic+"\t"+url);
	      }
	      return list;
		}catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		return search(str);
	}
    public static void main(String[] args) {
    	BlurBasic b =new BlurBasic();
    	//List<String> value = b.search("");
    }
}
