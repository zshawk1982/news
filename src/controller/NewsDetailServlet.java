package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;

/**
 * Servlet implementation class NewsDetailServlet
 */
public class NewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要查询的新闻ID
		String nid = request.getParameter("nid");
		//创建NewsService对象
		NewsService ns = new NewsService();
		//调用NewsService对象的queryNewsDetail，返回查询到的包裹新闻详情的Map对象
		Map<String,String> currentNews = ns.queryNewsDetail(nid);
		//将新闻详情放入request对象
		request.setAttribute("cnews", currentNews);
		//跳转到新闻详情页面
		request.getRequestDispatcher("newsDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
