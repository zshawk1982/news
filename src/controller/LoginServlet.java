 package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import vo.User;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求参数的编码格式
		request.setCharacterEncoding("utf-8");
		//获取登录表单参数
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		//创建UserService类对象
		UserService us = new UserService();
		//根据用户名和密码获得用户对象
		User u = us.queryUser(uname, pass);
		if(u!=null){
			//用户对象不为空将其保存到session中
			request.getSession().setAttribute("currentUser", u);
			//登录成功,跳转到首页面
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			//登录失败，维持不变
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
