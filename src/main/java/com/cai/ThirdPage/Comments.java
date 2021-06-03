package com.cai.ThirdPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Comments {


	public static void addComments(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String addComment = ThirdPage.Comment;
        String UserID= ThirdPage.id;

        try{

            conn = DBUtils.getConnection();
            String sql = "INSERT INTO comment (UserID, Commenttext) VALUES(?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, UserID);
            ps.setString(2, addComment);
            ps.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            DBUtils.close(conn, ps, rs);
        }
    }
     public static ArrayList<String> getComment(){
         ArrayList<String> commentList = new ArrayList<String>();
         Connection conn = null;
         PreparedStatement ps = null;
         ResultSet rs = null;


         try{

             conn = DBUtils.getConnection();
             String sql = "SELECT * FROM comment WHERE UserID =" + ThirdPage.id;
             ps=conn.prepareStatement(sql);
             rs = ps.executeQuery();
             while (rs.next()) {
                 String gotComment = rs.getString("Commenttext");
                 commentList.add(gotComment);
             }
             return commentList;


         }catch(Exception e){
             e.printStackTrace();
         }
         finally{
             DBUtils.close(conn, ps, rs);
         }
         return null;




     }









}
