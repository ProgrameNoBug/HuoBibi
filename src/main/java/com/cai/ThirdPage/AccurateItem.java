package com.cai.ThirdPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AccurateItem {
	public static Commodity getItem(String id){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            String sql = "select * from jd_item where id="+id;
            ps=conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String brand = rs.getString("brand");
                String price = rs.getString("price");
                String title = rs.getString("title");
                String picture = rs.getString("pic");
                String url = rs.getString("url");
                String sku=null;
                Commodity commodity = new Commodity(id, title, price, brand, url, picture, sku);
                return commodity;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            DBUtils.close(conn, ps, rs);
        }
        return null;
    }

}
