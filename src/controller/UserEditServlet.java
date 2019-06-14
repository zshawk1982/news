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
 * Servlet implementation class UserEditServlet
 */
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取修改的参数信息
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		String profession = request.getParameter("profession");
		String[] favourite=request.getParameterValues("favourite");
		String note = request.getParameter("note");
		String type = request.getParameter("type");
		UserService us = new UserService();
		//判断是查询，还是修改
		if(type.equals("query")){
			//是查询就根据id查询新闻信息
			User m = us.queryUserById(uid);
			//将查询结果放入request
			request.setAttribute("user", m);
			//跳转到newsEdit.jsp页面
			request.getRequestDispatcher("userEdit.jsp").forward(request, response);
		}else {
			//爱好需要特别处理
			String favour = "[";
			for(String f:favourite){
				favour+=f+",";
			}
			favour = favour.substring(0, favour.length()-1)+"]";
			//是修改就根据传递的修改信息进行修改
			int result = us.editUser(uname, pass, sex, profession, favour, note, uid);
			//修改成功跳转到查询列表页面,失败则调到错误页面
			if(result>0){
				response.sendRedirect("userListServlet");
			}else{
				response.sendRedirect("error.jsp");
			}	
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
