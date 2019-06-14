package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import vo.User;

/**
 * Servlet implementation class UserAddServlet
 */
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决参数信息乱码问题
		request.setCharacterEncoding("utf-8");
		//获取用户信息
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
			response.sendRedirect("userListServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
