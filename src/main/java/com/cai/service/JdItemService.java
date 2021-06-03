package com.cai.service;

//import cn.hutool.db.handler.BeanListHandler;
import com.cai.blursearch.BlurBasic;
import com.cai.entity.JdItem;
import com.cai.history.GetHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JdItemService {

    public List<JdItem>  queryJdItemList(){

        BlurBasic blurBasic = new BlurBasic();
        Connection con = blurBasic.Connection();
        Statement statement = null;
        List<JdItem> list = new ArrayList<>();
        try {
            statement = con.createStatement();
            String sql = "select * from jd_item order by rand() limit 3";
            ResultSet res =  statement.executeQuery(sql);


            BeanListHandler<JdItem> bh = new BeanListHandler<>(JdItem.class);
            list = bh.handle(res);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
