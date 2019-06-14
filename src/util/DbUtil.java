package util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DbUtil {
	/**
	 * 1.得到数据库链接
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			//获取db.properties文件中的数据库连接信息
			InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			//构造Properties对象并加载连接信息流
			Properties p = new Properties();
			p.load(is);
			//加载数据库驱动
			Class.forName(p.getProperty("drivername"));
			//指定连接字符串和用户名，密码得到数据库连接
			con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	//2.关闭数据库资源
	public static void closeResource(ResultSet rs,Statement st,Connection con) {
		try {
			if(rs!=null) {
				//结果集不为空，关闭结果集
				rs.close();
			}
			if(st!=null) {
				//语句块不为空，关闭语句块
				st.close();
			}
			if(con!=null) {
				//连接不为空，关闭连接
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 3.通用查询（普通版）
	 * @param sql 形如:select * from user where uname =? and pass=?
	 * @param o 对象数组，用于接收传入对应？的替换参数
	 * @return 返回结果为包裹查询结果的List<Map>结果的集合
	 */
	public static List<Map<String,String>> genericQuery(String sql,Object[] o){
		//得到数据库连接
		Connection con = getConnection();
		List<Map<String,String>> list = null;
		PreparedStatement ps= null;
		try {
			//通过sql构造prepareStatement对象
			ps = con.prepareStatement(sql);
			if(o!=null) {
				//循环替换问号
				for(int i=1;i<=o.length;i++) {
					ps.setObject(i, o[i-1]);
				}
			}
			//执行查询
			ResultSet rs=ps.executeQuery();
			//根据结果集对象得到结果集元数据对象
			ResultSetMetaData rsmd = rs.getMetaData();
			list = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				//构造hashmap，一个map对应一行记录
				Map<String,String> m = new HashMap<String,String>();
				//填充map，key值为列名，value为列值
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					m.put(rsmd.getColumnName(i), rs.getString(i));
				}
				//每完成一行加入list中
				list.add(m);
			}
			//关闭资源
			closeResource(rs, ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 4.通用查询（高级版）
	 * @param sql 形如:select * from user where uname =? and pass=?
	 * @param o 对象数组，用于接收传入对应？的替换参数
	 * @param c 泛型T所对应类型的class类型对象
	 * @return 返回结果为包裹查询结果的List<T>结果的集合
	 */
	public static <T> List<T> genericQuery(String sql,Object[] o,Class<T> c){
		//得到数据库连接
		Connection con = getConnection();
		List<T> list = null;
		PreparedStatement ps= null;
		try {
			//通过sql构造prepareStatement对象
			ps = con.prepareStatement(sql);
			if(o!=null) {
				//循环替换问号
				for(int i=1;i<=o.length;i++) {
					ps.setObject(i, o[i-1]);
				}
			}
			//执行查询
			ResultSet rs=ps.executeQuery();
			//根据结果集对象得到结果集元数据对象
			ResultSetMetaData rsmd = rs.getMetaData();
			list = new ArrayList<T>();
			while(rs.next()) {
				//利用Class对象构造泛型对象
				T t = c.newInstance();
				//通过结果集元数据对象得到列数，循环遍历之
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					//通过结果集元数据对象得到列名
					String columnName = rsmd.getColumnName(i);
					//通过Class对象得到声明的set方法对象
					Method m = c.getDeclaredMethod("set"+columnName.
					replaceFirst(columnName.substring(0,1), columnName.
					substring(0,1).toUpperCase()), c.getDeclaredField(columnName).getType());
					//动态调用set方法对象赋值
					m.invoke(t, rs.getObject(i));
				}
				//将泛型对象放入集合
				list.add(t);
			}
			//关闭资源
			closeResource(rs, ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Map<String,String> genericQuerySingle(String sql,Object[] o){
		Connection con = getConnection();
//		List<Map<String,String>> list = null;
		Map<String,String> m = null;
//		Statement st;
		PreparedStatement ps= null;
		try {
			ps = con.prepareStatement(sql);
			if(o!=null) {
				for(int i=1;i<=o.length;i++) {
					ps.setObject(i, o[i-1]);
				}
			}
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
				rs.next();
				m = new HashMap<String,String>();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					m.put(rsmd.getColumnName(i), rs.getString(i));
				}
//				list.add(m);
//			}
			closeResource(rs, ps, con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
		
	}
	
	public static <T> T genericQuerySingle(String sql,Object[] o,Class<T> c){
		Connection con = getConnection();
//		Statement st;
		PreparedStatement ps= null;
		T t = null;
		try {
//			st = con.createStatement();
			ps = con.prepareStatement(sql);
//			ResultSet rs=st.executeQuery(sql);
			if(o!=null) {
				for(int i=1;i<=o.length;i++) {
					ps.setObject(i, o[i-1]);
				}
			}
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
//			list = new ArrayList<T>();
//			while(rs.next()) {
			rs.next();
//				Map<String,String> m = new HashMap<String,String>();
				t = c.newInstance();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
//					m.put(rsmd.getColumnName(i), rs.getString(i));
					String columnName = rsmd.getColumnName(i);
					Method m = c.getDeclaredMethod("set"+columnName.replaceFirst(columnName.substring(0,1), columnName.substring(0,1).toUpperCase()), c.getDeclaredField(columnName).getType());
					m.invoke(t, rs.getObject(i));
							
				}
//				list.add(t);
//			}
			closeResource(rs, ps, con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}
	
	
	/**
	 * 5.通用增删改DML操作
	 * @param sql形如:update user set uname =?
	 * @param o 对象数组，用于接收传入对应？的替换参数
	 * @return 返回值为DML操作的受影响行数
	 */
	public static int genericDML(String sql,Object[] o) {
		//得到数据库连接
		Connection con = getConnection();
		PreparedStatement ps= null;
		int result = 0;
		try {
			//通过sql构造prepareStatement对象
			ps = con.prepareStatement(sql);
			//循环替换问号
			if(o!=null) {
				for(int i=1;i<=o.length;i++) {
					ps.setObject(i, o[i-1]);
				}
			}
			//执行增删改操作
			result = ps.executeUpdate();
			//关闭资源
			closeResource(null, ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回受影响的行数
		return result;
	}
	
}
