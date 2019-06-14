package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;

/**
 * Servlet implementation class NewsDeleteServlet
 */
public class NewsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取修改的参数信息
		String nid = request.getParameter("nid");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pubtime = request.getParameter("pubtime");
		NewsService ns = new NewsService();
		//判断是查询，还是修改
		if(type.equals("query")){
			//是查询就根据id查询新闻信息
			Map<String,String> m = ns.queryNewsDetail(nid);
			//将查询结果放入request
			request.setAttribute("news", m);
			//跳转到newsEdit.jsp页面
			request.getRequestDispatcher("newsEdit.jsp").forward(request, response);
		}else {
			//是修改就根据传递的修改信息进行修改
			int result = ns.editNews(title, content, pubtime, nid);
			//修改成功跳转到查询列表页面,失败则调到错误页面
			if(result>0){
				response.sendRedirect("newsListServlet");
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
