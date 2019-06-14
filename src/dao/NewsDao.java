package dao;

import java.util.List;
import java.util.Map;

import util.DbUtil;
import util.Pager;
import vo.News;

public class NewsDao {
	public int addNews(News n){
		return DbUtil.genericDML("insert into news(title,content,pubtime,uid,isValid) values(?,?,?,?,?)", new Object[]{n.getTitle(),n.getContent(),n.getPubtime(),n.getUid(),n.getIsValid()});
	}
	public int deleteNews(String nid){
		return DbUtil.genericDML("update news set isValid=0 where nid=?", new Object[]{nid});
	}
	public int editNews(String title,String content,String pubtime,String nid){
		return DbUtil.genericDML("update news set title=?,content=?,pubtime=? where nid=?", new Object[]{title,content,pubtime,nid});
	}
	
	public Map<String,String> queryNewsCount(String title){
		//根据是否有查询条件（这里的查询条件即新闻标题）来调用不同的sql
		if(title==null||title=="") {
			return DbUtil.genericQuerySingle("select count(*) as count from user u,news n where u.uid=n.uid and n.isValid=1",null);
			
		}else {
			return DbUtil.genericQuerySingle("select count(*) as count from user u,news n where u.uid=n.uid and n.isValid=1 and n.title like '%"+title+"%'",null);
		}
	}
	public List<Map<String,String>> queryAllNewsByPage(Pager p,String title){
		//计算查询的偏移量，该偏移量是为limit服务的
		int offset = (p.getCurrentPage()-1)*p.getPageSize();
		//根据是否有查询条件（这里的查询条件即新闻标题）来调用不同的sql
		if(title==null||title=="") {
			return DbUtil.genericQuery("select n.nid,n.title,n.pubtime,u.uname,n.uid from user u,news n where u.uid=n.uid and n.isValid=1 limit "+offset+","+p.getPageSize(),null);
		}else {
			return DbUtil.genericQuery("select n.nid,n.title,n.pubtime,u.uname,n.uid from user u,news n where u.uid=n.uid and n.isValid=1 and n.title like '%"+title+"%' limit "+offset+","+p.getPageSize(), null);
		}
	}
	
	
	public List<Map<String,String>> queryAllNews(){
		return DbUtil.genericQuery("select n.nid,n.title,n.pubtime,u.uname,n.uid from user u,news n where u.uid=n.uid and n.isValid=1 order by pubtime desc", null);
	}
//	public List<Map<String,String>> queryAllNewsByCondition(String title,String uname){
//		String sql = "select n.nid,n.title,n.pubtime,u.uname from user u,news n where u.uid=n.uid and n.isValid=1";
//		
//		if(title!=null&&!title.equals("")) {
//			sql = sql+" and n.title like '%"+title.trim()+"%'";
//		}
//		if(uname!=null&&!uname.equals("")) {
//			sql = sql+" and u.uname like '%"+uname.trim()+"%'";
//		}
//		return DbUtil.genericQuery(sql, null);
//		
//		
//	}
	
	public Map<String,String> queryNewsDetail(String nid){
		return DbUtil.genericQuerySingle("select n.nid,n.title,n.content,n.pubtime,u.uname from user u,news n where u.uid=n.uid and n.nid=?",new Object[]{nid});
	}
	
	
	
	
	
	
	
}
 