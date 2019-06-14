package service;

import java.util.List;
import java.util.Map;

import util.DbUtil;
import util.Pager;
import vo.News;
import vo.User;
import dao.NewsDao;
import dao.UserDao;

public class NewsService {
	public int addNews(News n){
		NewsDao nd = new NewsDao();
		return nd.addNews(n);
	}
	
	public List<Map<String,String>> queryAllNews(){
		NewsDao nd = new NewsDao();
		return nd.queryAllNews();
	}
	
//	public List<Map<String,String>> queryAllNewsByCondition(String title,String uname){
//		NewsDao nd = new NewsDao();
//		return nd.queryAllNewsByCondition(title,uname);
//		
//	}
	
	public Map<String,String> queryNewsDetail(String nid){
		NewsDao nd = new NewsDao();
		return nd.queryNewsDetail(nid);
	}
	
	public int deleteNews(String nid){
		NewsDao nd = new NewsDao();
		return nd.deleteNews(nid);
	}
	
	public int editNews(String title,String content,String pubtime,String nid){
		NewsDao nd = new NewsDao();
		return nd.editNews(title, content, pubtime, nid);
	}
	
	public List<Map<String,String>> queryAllNewsByPage(Pager p,String title){
		NewsDao nd = new NewsDao();
		return nd.queryAllNewsByPage(p,title);
	}
	public Map<String,String> queryNewsCount(String title){
		NewsDao nd = new NewsDao();
		return nd.queryNewsCount(title);
	}
	
}
