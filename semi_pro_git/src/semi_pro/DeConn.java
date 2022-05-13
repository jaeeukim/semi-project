package semi_pro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class DeConn {
	
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL =  "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private static final String USER_NAME = "FOR_SEMI";
	private static final String PASSWORD = "FOR_SEMI";
	
	private String url_address;
	private Statement stat;
	private Connection conn2;
//	private PreparedStatement pstat;
	private ResultSet rs;
	
	public DeConn(String domain, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", domain, port, serviceName);
		this.initConnect(username, password);
	}
	
	private void initConnect(String username, String password) throws Exception {
		// Driver 등록
		Class.forName(DRIVER_NAME);
		
		// DBMS 연결
		conn2 = DriverManager.getConnection(BASE_URL + url_address, username, password);
		conn2.setAutoCommit(false);
		
		//  Statement 생성
		 stat = conn2.createStatement();
	}
	
	public void close() throws Exception {
		// 5. 연결 해제
		this.stat.close();
	//	this.pstat.close();
		this.conn2.close();
	}
	
	
	
	
	
//	public DeConn(File config) throws Exception {
//		Map<String, String> map = new HashMap<String, String>();
//		BufferedReader br = new BufferedReader(new FileReader(config));
//		while(br.ready()) {
//			String[] keyValue = br.readLine().split("=");
//			map.put(keyValue[0].strip(), keyValue[1].strip());
//		}
//		this.initConnect(map.get("username"), map.get("password"));
//		System.out.println("연결완료");
//	}
//	
//	public static void main(String[] args) throws Exception {
//		String homePath = System.getProperty("user.home");
//		DeConn dc = new DeConn(new File(homePath + "/semipro.conf"));
//	}
	
	

//	private void initConnect(String username, String password) throws Exception {
//		// Driver 등록
//		Class.forName(DRIVER_NAME);
//		
//		// DBMS 연결
//		conn2 = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//		conn2.setAutoCommit(false);
//		
//		//  Statement 생성
//		stat = conn2.createStatement();
//	}
	
//	public PreparedStatement getPstat(String sql) throws Exception {
//		pstat = conn2.prepareStatement(sql);
//		return pstat;
//	}
	
	
	public ResultSet sendSelectQuery(String sql) throws Exception{
		rs = this.stat.executeQuery(sql);
		return rs;
	}
	
	public int sendInsertQuery(String sql) throws Exception{
		int rs = this.stat.executeUpdate(sql);
		return rs;
	}
	
	public int sendDeleteQuery(String sql) throws Exception{
		int rs = this.stat.executeUpdate(sql);
		return rs;
	}

	public int sendUpdateQuery(String sql) throws Exception{
		int rs = this.stat.executeUpdate(sql);
		return rs;
	}
	
	
	public void commit() throws Exception{
		this.conn2.commit();
	}
	
	public void rollback() throws Exception{
		this.conn2.rollback();
	}
	

	
	
//	public static void main(String[] args) throws Exception {
//		DeConn dc = new DeConn();
//		
//		// int rowCount = dc.sendInsertQuery("INSERT INTO desire_t VALUES('감자2', '음식', 1800, '그냥', '하', 10)");
//		int rowCount = dc.sendDeleteQuery("DELETE FROM DESIRE_T WHERE PROD_NAME = '감자2'");
//		System.out.println(rowCount + " 개 행이 반영되었습니다.");
////		ResultSet rs = dc.sendSelectQuery("SELECT * FROM DESIRE_T");
////		while(rs.next()) {
////			System.out.println(rs.getString("prod_name"));
////		}
//		dc.commit();
////		rs.close();
//		dc.close();
//	}
	

	
	
	
	
}
