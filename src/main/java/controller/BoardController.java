package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardDAO boardDAO = new BoardDAO();
	private int num;
	
    public BoardController() {
        super();
        num = 1;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//어떤 페이지에서 요청이 왓는지 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		

		
		//응답 페이지
		String page = "";
		boolean isRedirect = false;
		
		//게시글 목록 페이지로 이동
		if(command.equals("/boardList.do")) {
			//게시글 목록 조회 쿼리 실행
			//List<BoardDTO> 자료형으로 리턴 받았으니 받을대도 똑같은 자료형으로 받는다!!!
			List<BoardDTO> list = boardDAO.selectBoardList();
			//게시글 목록 데이터를 jsp에 던짐
			request.setAttribute("list",  list);
			page = "board_list.jsp";
		}
		
		//게시글 등록 페이지로 이동
		if(command.equals("/boardWriteForm.do")) {
			page = "board_write_form.jsp";
		}
		
		//게시글 등록
		if(command.equals("/regBoard.do")) {
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			//boardDAO의 객체에서 만든 insertBoard실행하겠다.
			boardDAO.insertBoard(++num, title, writer, content);
			
			page = "boardList.do";
			isRedirect = true;
		}
		
		//상세 페이지로 이동
		if(command.equals("/boardDetail.do")) {
			//넘어오는 글번호 데이터 받기
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			
			//상세조회 쿼리 실행
			BoardDTO boardDetail = boardDAO.selectBoard(boardNum);
			
			request.setAttribute("boardDetail", boardDetail);
			page = "board_detail.jsp";
		}
		
		//게시글 삭제
		if(command.equals("/boardDelete.do")) {
			//넘어오는 글번호 데이터 받기
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		
		//상세조회 쿼리 실행
			boardDAO.deleteBoard(boardNum);
			
		//게시판 목록으로 페이지 이동
			page = "boardList.do";
			isRedirect = true;
		}
		
		
		//게시글 수정 데이터 받아서 글수정 페이지로 이동
		if(command.equals("/detailToUpdate.do")) {
			int num = Integer.parseInt(request.getParameter("boardNum"));
			BoardDTO boardUpdate = boardDAO.detailToUpdate(num);
			request.setAttribute("boardUpdate", boardUpdate); 
			page = "board_update_form.jsp";
		}
		
		
		//게시글 수정
		if(command.equals("/updateBoardDetail.do")){
			int num = Integer.parseInt(request.getParameter("boardNum"));
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String createDate = request.getParameter("createDate");
			String content = request.getParameter("content");
			
			boardDAO.updateBoard(num, title, writer, createDate, content);
			request.setAttribute("boardNum", num);
			
			page = "boardDetail.do";
		}
		
		
		//페이지 이동
		if(isRedirect) {
			response.sendRedirect(page);
		}
		
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);	
		}
	}
}
