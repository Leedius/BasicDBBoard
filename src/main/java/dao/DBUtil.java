package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//디비 작업 관련 유틸 메소드
public class DBUtil {
	//자바와 디비를 연결에 필요한 connection 객체 생성 메소드
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context init = new InitialContext();
	        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	        conn = ds.getConnection();	
		}catch (Exception e) {
			System.out.println("데이터베이스 연결 실패~");
			//왜 실패했는지 오류 내용 콘솔에 뛰워줌.
			e.printStackTrace();
		}
		return conn;
	}
	//사용한 디비 관련 객체 소멸 메소드
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("데이터베이스 객체 소멸 오류~");
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("데이터베이스 객체 소멸 오류~");
			e.printStackTrace();
		}
	}
}
