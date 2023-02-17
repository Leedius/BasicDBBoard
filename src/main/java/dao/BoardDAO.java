package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.print.DocFlavor.STRING;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

import dto.BoardDTO;


public class BoardDAO {
	//oracle과 자바를 연결시켜줄 수 있는 객체
	private Connection conn = null;
	

	// 실행할 쿼리문 작성
	private String sql = "";

	// 쿼리를 실행시켜주는 객체
	private PreparedStatement pstmt = null;
	
	// 조회된 데이터를 저장하는 객체
	private ResultSet rs = null;
	
	// 게시글 목록 조회
	public List<BoardDTO> selectBoardList() {
		//게시글 목록을 저장할 리스트 객체
		List<BoardDTO> boardList = new ArrayList<>();
		
		//실행할 쿼리
		sql = "SELECT "
				+ "BOARD_NUM"
				+ ", TITLE"
				+ ", WRITER"
				+ ", CREATE_DATE "
			+ "FROM "
				+ "BASIC_BOARD";
				
		
		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함

			// 쿼리 실행(조회이기때문에 execute뒤에 Query()를 씀.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int boardNum = rs.getInt("BOARD_NUM");
				String title = rs.getString("TITLE");
				String writer = rs.getString("WRITER");
				String createDate = rs.getString("CREATE_DATE");
				
				//조회된 데이터에는 content가 없어서 마지막 항목은 null로 넣는다
				BoardDTO board = new BoardDTO(boardNum, title, writer, createDate, null);
				boardList.add(board);
			}

		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		//조회된 모든 데이터를 지닌 boardList 객체 리턴
		return boardList;
	}
	
	//게시글 등록(몇개가 들어갔는지 확인하기 위해서 리턴타입인 int)
	public int insertBoard(int boardNum, String title, String writer, String content) {
		//게시글 목록을 저장할 리스트 객체
		int result = 0;
		
		//실행할 쿼리
		sql = "INSERT INTO BASIC_BOARD ("
				+ "BOARD_NUM"
				+ ", TITLE"
				+ ", WRITER"
				+ ", CONTENT"
				+ ") "
				+ "VALUES ("
				+ "(SELECT MAX(BOARD_NUM) + 1 FROM BASIC_BOARD)"
				+ ", ?"
				+ ", ?"
				+ ", ?"
				+ ")";
				
		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);
			
			// ?값을 채워줘야 함
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			// 쿼리 실행(몇 행이 삽입되었는지 result에 저장)
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	//게시글 상세 조회
	public BoardDTO selectBoard(int boardNum) {

		
		// 실행할 쿼리
		sql = "SELECT "
				+ "BOARD_NUM"
				+ ", TITLE"
				+ ", WRITER"
				+ ", CREATE_DATE"
				+ ", CONTENT"
			+ "FROM "
				+ "BASIC_BOARD == ?";

		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함
			pstmt.setInt(1, boardNum);

			// 쿼리 실행(조회이기때문에 execute뒤에 Query()를 씀.
			rs = pstmt.executeQuery();

//			while (rs.next()) {
				String title = rs.getString("TITLE");
				String writer = rs.getString("WRITER");
				String createDate = rs.getString("CREATE_DATE");
				String content = rs.getString("CONTENT");

				// 조회된 데이터에는 content가 없어서 마지막 항목은 null로 넣는다
				BoardDTO boardDetail = new BoardDTO(boardNum, title, writer, createDate, content);
//			}

		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		// 조회된 모든 데이터를 지닌 boardList 객체 리턴
		return 
	}
	
	//게시글 삭제
	public void deleteBoard() {
		
	}
	
	//게시글 수정
	public void updateBoard() {
		
	}
}
