package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.NewsService;
import service.UserService;
import vo.User;

/**
 * Servlet implementation class UserDetailServlet
 */
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要查询的用户ID
		String uid = request.getParameter("uid");
		//创建UserService对象
		UserService us = new UserService();
		//调用UserService对象的queryUserById，返回查询到的用户对象
		User currentUser = us.queryUserById(uid);
		//将用户对象放入request对象
		request.setAttribute("cuser", currentUser);
		//跳转到显示页面
		request.getRequestDispatcher("userDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
