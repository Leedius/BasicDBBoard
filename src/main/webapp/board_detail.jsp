<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}

.board_title{
	text-align: center;
	padding: 20px 0;
}

table{
   border-top: 2px solid black;
   border-bottom: 2px solid black;
   border-collapse: collapse;
   text-align: center;
   width: 600px;
   margin: 0 auto;
}

table .top{
	background-color: #5b9bd5;
}

table .info{
	background-color: #eaeff7;
}

thead{
	
}

thead > tr{
	border-bottom: 1px solid silver;
}

thead > tr > td{
	padding: 10px 0;
	bo
}


tbody > tr{
	border-bottom: 1px solid silver;
}

tbody .info{
	text-align: left;
	padding-left: 3px;
}	

tbody > tr > td{
	padding: 10px 0;
}

.button{
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.button > input {
	display: inline-block;
	min-width: 30px;
	margin-left: 10px;
	padding: 5px;
	border: 1px solid black;
	border-radius: 2px;
	font-size: 1.2rem;
}

.button > input{
	background: white;	
	color: black;
}

</style>
</head>
<body>
	<div class="board_title">
		<h2>글 상세 내용</h2>
	</div>
	<form action="deleteBoard.do" method="post">
	<div class="content_wrap">
		<div class="content_table">
			<table>
				<colgroup>
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="*">
				</colgroup>			
				<thead>
					<tr>
						<td class="top">글번호</td>
						<td class="info">${boardDetail.boardNum }</td>
						<td class="top">작성자</td>
						<td class="info">${boardDetail.writer }</td>
						<td class="top">작성일</td>
						<td class="info">${boardDetail.createDate }</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="top">제목</td>
						<td class="info" colspan="5">${boardDetail.title }</td>
					</tr>
					<tr>
						<td class="top">내용</td>
						<td class="info" colspan="5">${boardDetail.content }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="button">
			<input type="button" value="뒤로가기" onclick="location.href='boardList.do'"> 
			<input type="button" value="수정" onclick="location.href='detailToUpdate.do?boardNum=${boardDetail.boardNum}';"> 
			<input type="button" value="삭제" onclick="location.href='boardDelete.do?boardNum=${boardDetail.boardNum}';">
		</div>
	</div>
	</form>
</body>
</html>