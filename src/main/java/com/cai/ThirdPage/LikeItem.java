package com.cai.ThirdPage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LikeItem {


public static String likes( String price, String brand){
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<String> likelist = new ArrayList<String>();
    String result = "";
    try{
        conn = DBUtils.getConnection();
        String sql = "select * from jd_item where brand="+"'"+brand+"'";
        ps=conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String title = rs.getString("title");
            String thisprices = rs.getString("price");
            System.out.println("....");
            float thisprice = Float.parseFloat(thisprices);
            float prices = Float.parseFloat(price);
            System.out.println("12345");
            if(thisprice>=prices-1000.00&&thisprice<=prices+1000.00){
                if (likelist.size()<4) {
                    likelist.add("<br> <a href=\"ItemServlet/?id=\""+ id +">"+title + "\n" + "price:" + thisprices+"</a></br>");
                }
                else{
                    break;
                    }
            }



        }
        for(String i:likelist){
            result = result  +i ;

        }
        return result;
    }catch(Exception e){
        e.printStackTrace();
    }
    finally{
        DBUtils.close(conn, ps, rs);
    }
    return null;
}
public static void main(String []args){

    System.out.println(likes("4899.00", "APPLE"));
}

    }
