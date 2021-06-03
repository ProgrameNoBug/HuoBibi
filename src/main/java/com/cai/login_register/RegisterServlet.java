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
		
    	request.setCharacterEncoding("gbk");//���벿��
		response.setCharacterEncoding("gbk");
		response.setHeader("content-type", "text/html;charset=gbk");//���벿��
		
		String name=request.getParameter("id");//���html�������Ϣ
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		MysqlTool logining=new MysqlTool();
		boolean flag= logining.seekusername(name); //�ж����ݿ����Ƿ�������û���
		PrintWriter printwriter=response.getWriter();//�����������ʾ
		if(flag==true) {
		logining.write(name, password,email);//ʹ������ĵڶ�����д�����ݿ�
		response.sendRedirect("./login.html");
		}
		else {
			response.sendRedirect("./register.html");
			
		}
	}


}