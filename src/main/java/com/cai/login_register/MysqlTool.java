package com.cai.login_register;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlTool {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	public Connection Connection(){
		// TODO Auto-generated method stub
		String Driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/register?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
		String name="root";
		String code="123456";
		
		try {
			Class.forName(Driver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url, name, code);
			return con;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void read()  {
		MysqlTool c=new MysqlTool();
		con=c.Connection();
		try {
			sql=con.createStatement();
			res=sql.executeQuery("select * from register");
			while(res.next()) {
				String name=res.getString("username");
				System.out.println(res.getString("username").length());
				String password=res.getString("password");
				String email=res.getString("email");
				System.out.println(name+" "+password+" "+email);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void write(String name,String password,String email) {
		MysqlTool c=new MysqlTool();
		con=c.Connection();
		try {
			sql=con.createStatement();
			String  code= "insert into register(username,password,email) values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(code);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public boolean seek (String name,String password) {
		MysqlTool c=new MysqlTool();
		con=c.Connection();
		try {
			sql=con.createStatement();
			res=sql.executeQuery("select * from register");
			while(res.next()) {
				if(name.equals(res.getString("username"))) {					
					if(password.equals(res.getString("password"))) {
						System.out.println("login successfully");
						return true;
					}
						
					else {
						System.out.println("account name or password is wrong！");
						return false;
					}
						
				}
			}
			System.out.println("NO user");
			return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean seekusername (String name) {
		  MysqlTool c=new MysqlTool();
		  con=c.Connection();
		  try {
		   sql=con.createStatement();
		   String find = "select * from register where username='" + name + "'";
		   res=sql.executeQuery(find);
		   while(res.next()) {
//			   System.out.println("sas");
//			   System.out.println(res.getString("username").length());
//		    if(!res.getString("username").equals(name)) {     
//		    	System.out.println("User name is available！");
//		    	return true;
//		     }
//		      
//		     else {
//		    	 System.out.println("User name is not available");
//		      
//		      return false;
//		     }
//		      
			   System.out.println("User name is not available");
			   return false;
		    
		   }
		   return true;
		  }
		  catch(SQLException e) {
		   e.printStackTrace();
		   return false;
		  }
		 }
	public List<String> seekemail (String email) {
		  MysqlTool c=new MysqlTool();
		  List<String>list = new ArrayList<String>();
		  con=c.Connection();
		  try {
		   String sea = "select * from register where email ='" + email + "'";
		   sql=con.createStatement();
		   res=sql.executeQuery(sea);
		   
		   String username,password;
		      
		       while(res.next()) {
		         username=res.getString("username");
		         password=res.getString("password");
		         System.out.println(username+"\t"+password);//输出查询结果
		         list.add(username+"\t"+password);
		       
		       }
		       return list;

		  }catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		  return list;
		 }
	public static void search(String str)  {
		MysqlTool c=new MysqlTool();
		con=c.Connection();
		try {
			String sea = "select * from register where username like '%"+str+"%'";
			sql=con.createStatement();
			res=sql.executeQuery(sea);
			int id;
			String password,name;
	      System.out.println("id\t username\t password");
	      while(res.next()){
	        id=res.getInt("id");
	        name=res.getString(2);
	        password=res.getString("password");
	        System.out.println(id+"\t"+name+"\t"+password);//输出查询结果
	      }

		}catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		
	}
	public static void main(String[] args) {
		MysqlTool c=new MysqlTool();
		c.read();
//		c.write("caililicai", "123","qq@qq.com" );
		boolean flag= c.seekusername("cailil");
		System.out.println(flag);
		search("asd");

	}


}
