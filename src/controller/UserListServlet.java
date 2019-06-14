package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import service.UserService;
import util.Constant;
import util.Pager;
import vo.User;

/**
 * Servlet implementation class UserListServlet
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//查询用用户名和职业
		String uname = request.getParameter("uname")==null?"":URLDecoder.decode(request.getParameter("uname"),"utf-8");
		String profession = request.getParameter("profession")==null?"":URLDecoder.decode(request.getParameter("profession"),"utf-8");
		//当前的页码
		String currentPage = request.getParameter("currentPage");
		//创建NewsSerivce对象
		UserService us = new UserService();
		//得到用户数量
		Map<String,String> m = us.queryUsersCount(uname, profession);
		//创建分页工具对象
		Pager p = new Pager();
		//设置当前页码
		p.setCurrentPage(currentPage==null?1:Integer.parseInt(currentPage));
		//设置一页多少条记录,这里用Constant.PAGESIZE这个常量来定义
		p.setPageSize(Constant.PAGESIZE);
		//设置总记录数
		p.setTotalCount(Integer.parseInt(m.get("count")));
		//计算总页数
		int totalPage =  (p.getTotalCount()%p.getPageSize())==0?p.getTotalCount()/p.getPageSize():p.getTotalCount()/p.getPageSize()+1;
		//设置总页数
		p.setTotalPage(totalPage); 
		//得到用户记录集合
		List<User> userlist = us.queryAllUsersByPage(p, uname, profession);
		//将分页对象放入request
		request.setAttribute("p", p);
//		//将查询标题放入request
		request.setAttribute("uname", URLEncoder.encode(URLEncoder.encode(uname,"utf-8")));
		request.setAttribute("profession", URLEncoder.encode(URLEncoder.encode(profession,"utf-8")));
		//将用户集合放入request
		request.setAttribute("userlist", userlist);
		//跳转到用户列表界面
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
