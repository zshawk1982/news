 package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import vo.News;
import vo.User;

public class NewsAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsAddServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		//获取提交的新闻参数
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		News n = new News();
		n.setTitle(title);
		n.setContent(content);
		//创建时间格式化器
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//获取当前时间，并格式化,设置发布时间
		n.setPubtime(sdf.format(new Date()));
		//从session获取登录用户信息
		User currentUser = (User)request.getSession().getAttribute("currentUser");
		//设置发布人
		n.setUid(currentUser.getUid());
		n.setIsValid(1);
		//创建NewService对象
		NewsService ns = new NewsService();
		int result = ns.addNews(n);
		if(result>0){
			response.sendRedirect("newsListServlet");
		}else{
			response.sendRedirect("newsAdd.jsp");
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
