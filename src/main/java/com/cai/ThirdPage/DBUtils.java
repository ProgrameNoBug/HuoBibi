package com.cai.ThirdPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DBUtils {
	 private DBUtils(){}


	  static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/202?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true"
	                    , "root", "123456");

	        }

	    public static void close(Connection conn, Statement ps, ResultSet rs){
	        if(rs != null){
	            try{
	                rs.close();
	            }catch(SQLException e){
	                e.printStackTrace();
	            }
	        }
	        if(ps != null){
	            try{
	                ps.close();
	            }
	            catch (SQLException e){
	                e.printStackTrace();
	            }
	        }
	        if(conn != null){
	            try{
	                conn.close();
	            }catch(SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }

}
