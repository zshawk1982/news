package dao;

import java.util.List;
import java.util.Map;

import util.DbUtil;
import util.Pager;
import vo.User;

public class UserDao {
	public int addUser(User u){
		return DbUtil.genericDML("insert into user(uname,pass,sex,profession,favourite,note,type) values(?,?,?,?,?,?,?)", new Object[]{u.getUname(),u.getPass(),u.getSex(),u.getProfession(),u.getFavourite(),u.getNote(),u.getType()});
	}
	public int deleteUser(String uid){
		return DbUtil.genericDML("update user set isValid=0 where uid=?", new Object[]{uid});
	}
	public int editUser(String uname,String pass,String sex,String profession,String favourite,String note,String uid){
		return DbUtil.genericDML("update user set uname=?,pass=?,sex=?,profession=?,favourite=?,note=? where uid=?", new Object[]{uname,pass,sex,profession,favourite,note,uid});
	}
	
	public User queryUser(String uname,String pass){
		List<User> users = DbUtil.genericQuery("select * from user where uname=? and pass=?", new Object[]{uname,pass} , User.class);
		return (users.size()>0?users.get(0):null);
	}
	
	public User queryUserById(String uid){
		return DbUtil.genericQuerySingle("select * from user where uid=?", new Object[]{uid}, User.class);
	}
	public Map<String,String> queryUsersCount(String uname,String profession){
		//根据是否有查询条件（这里的查询条件即用户名和职业）来调用不同的sql
		String sql = "select count(*) as count from user u where u.isValid=1";
		if(uname!=null&&!uname.equals("")) {
			sql = sql+" and u.uname like '%"+uname.trim()+"%'";
		}
		if(profession!=null&&!profession.equals("")) {
			sql = sql+" and u.profession like '%"+profession.trim()+"%'";
		}
		return DbUtil.genericQuerySingle(sql,null);
	}
	public List<User> queryAllUsersByPage(Pager p,String uname,String profession){
		//计算查询的偏移量，该偏移量是为limit服务的
		int offset = (p.getCurrentPage()-1)*p.getPageSize();
		//根据是否有查询条件来调用不同的sql
		String sql = "select * from user u where u.isValid=1 ";
		if(uname!=null&&!uname.equals("")) {
			sql = sql+" and u.uname like '%"+uname.trim()+"%'";
		}
		if(profession!=null&&!profession.equals("")) {
			sql = sql+" and u.profession like '%"+profession.trim()+"%'";
		}
		sql+=" limit "+offset+","+p.getPageSize();
		return DbUtil.genericQuery(sql,null,User.class);
	}
	
	
	public List<User> queryAllUsers(){
		return DbUtil.genericQuery("select * from user u where u.isValid=1", null,User.class);
	}
	
}
 