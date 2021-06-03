package com.cai.Controller;

//import com.alibaba.fastjson.JSON;
import com.cai.blursearch.BlurBasic;
import com.cai.entity.JdItem;
import com.cai.service.JdItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 1
 * @data 2021/5/10 19:29
 */
@WebServlet("/JdItemController")
public class JdItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//编码部分
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");//解码部分
        JdItemService service = new JdItemService();
        List<JdItem> jdItem = service.queryJdItemList();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(JSON.toJSONString(jdItem));
    }

}
