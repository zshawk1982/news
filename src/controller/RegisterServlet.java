 package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import vo.User;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
		//解决参数信息乱码问题
		request.setCharacterEncoding("utf-8");
		//获取用户注册信息
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		String profession = request.getParameter("profession");
		String[] favourite=request.getParameterValues("favourite");
		String note = request.getParameter("note");
		//创建注册的领域对象，用于传递给service层
		User u = new User();
		u.setUname(uname);
		u.setPass(pass);
		u.setSex(Integer.parseInt(sex));
		u.setProfession(profession);
		u.setFavourite(Arrays.toString(favourite));
		u.setNote(note);
		u.setType(0);
		//调用UserService判断用户是否注册成功，成功跳转到登录页面，否则维持不动
		UserService us = new UserService();
		int result = us.addUser(u);
		if(result>0){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("register.jsp");
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
