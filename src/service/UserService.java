package service;

import java.util.List;
import java.util.Map;

import util.DbUtil;
import util.Pager;
import vo.User;
import dao.UserDao;

public class UserService {
	public int addUser(User u){
		UserDao ud = new UserDao();
		return ud.addUser(u);
	}
	
	public User queryUser(String uname,String pass){
		UserDao ud = new UserDao();
		return ud.queryUser(uname, pass);
	}
	
	
	public User queryUserById(String uid){
		UserDao ud = new UserDao();
		return ud.queryUserById(uid);
	}
	
	public int deleteUser(String uid){
		UserDao ud = new UserDao();
		return ud.deleteUser(uid);
	}
	
	public int editUser(String uname,String pass,String sex,String profession,String favourite,String note,String uid){
		UserDao ud = new UserDao();
		return ud.editUser(uname, pass, sex, profession, favourite, note, uid);
	}
	
	public List<User> queryAllUsersByPage(Pager p,String uname,String profession){
		UserDao ud = new UserDao();
		return ud.queryAllUsersByPage(p, uname, profession);
	}
	public Map<String,String> queryUsersCount(String uname,String profession){
		UserDao ud = new UserDao();
		return ud.queryUsersCount(uname, profession);
	}
	
	
}
