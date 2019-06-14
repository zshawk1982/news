package vo;

public class User {
	//用户ID
	private int uid;
	//用户名
	private String uname;
	//用户密码
	private String pass;
	//性别
	private int sex;
	//职业
	private String profession;
	//用户爱好
	private String favourite;
	//用户说明
	private String note;
	//用户类型
	private int type;
	//用户是否有效
	private int isValid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getFavourite() {
		return favourite;
	}
	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	
	public User(int uid, String uname, String pass, int sex, String profession, String favourite, String note, int type,
			int isValid) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pass = pass;
		this.sex = sex;
		this.profession = profession;
		this.favourite = favourite;
		this.note = note;
		this.type = type;
		this.isValid = isValid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
