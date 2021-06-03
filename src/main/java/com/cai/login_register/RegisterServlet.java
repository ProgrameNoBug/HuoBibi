package com.cai.login_register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("gbk");//编码部分
		response.setCharacterEncoding("gbk");
		response.setHeader("content-type", "text/html;charset=gbk");//解码部分
		
		String name=request.getParameter("id");//获得html界面的信息
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		MysqlTool logining=new MysqlTool();
		boolean flag= logining.seekusername(name); //判断数据库中是否有这个用户名
		PrintWriter printwriter=response.getWriter();//浏览器界面显示
		if(flag==true) {
		logining.write(name, password,email);//使用上面的第二步，写入数据库
		response.sendRedirect("./login.html");
		}
		else {
			response.sendRedirect("./register.html");
			
		}
	}


}
