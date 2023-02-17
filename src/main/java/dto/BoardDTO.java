package dto;

public class BoardDTO {
	private int boardNum;
	private String title;
	private String writer;
	private String createDate;
	private String content;
	
	public BoardDTO() {
		
	}
	
	//컨텐츠까지 포함된 생성자
	public BoardDTO(int boardNum, String title, String writer, String createDate, String content) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.writer = writer;
		this.createDate = createDate;
		this.content = content;
	}


	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
}
