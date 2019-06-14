package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import util.Constant;
import util.Pager;

/**
 * Servlet implementation class NewsListServlet
 */
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//查询用的新闻标题
		String title = request.getParameter("title")==null?"":URLDecoder.decode(request.getParameter("title"),"utf-8");
		//当前的页码
		String currentPage = request.getParameter("currentPage");
		//创建NewsSerivce对象
		NewsService ns = new NewsService();
		//得到新闻数量
		Map<String,String> m = ns.queryNewsCount(title);
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
		//得到新闻记录集合
		List<Map<String,String>> newslist = ns.queryAllNewsByPage(p,title);
		//将分页对象放入request
		request.setAttribute("p", p);
		//将查询标题放入request
		request.setAttribute("title", URLEncoder.encode(URLEncoder.encode(title,"utf-8")));
		//将新闻集合放入request
		request.setAttribute("newslist", newslist);
		//跳转到新闻查询页面
		request.getRequestDispatcher("newsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
