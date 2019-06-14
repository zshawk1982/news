package vo;

public class News {
	//新闻ID
	private int nid;
	//新闻标题
	private String title;
	//新闻内容
	private String content;
	//发布时间
	private String pubtime;
	//发布人ID
	private int uid;
	//新闻是否有效
	private int isValid;
	
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public News(int nid, String title, String content, String pubtime, int uid, int isValid) {
		super();
		this.nid = nid;
		this.title = title;
		this.content = content;
		this.pubtime = pubtime;
		this.uid = uid;
		this.isValid = isValid;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
