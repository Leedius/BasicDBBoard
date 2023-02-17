<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

thead .top > td{
	padding : 10px 0;	
	font-size: 1.1rem;
}

tbody > tr{
	border-bottom: 1px solid silver;
	background-color: #eaeff7;
}

tbody > tr > td{
	padding: 3px 0;
}

tbody > tr > td:last-child{
	font-size: 0.8rem;
}
	

table .top{
	background-color: #5b9bd5;
	color: white;
	font-weight: bolder;
}
.write_button{
	margin: 10px auto;
	text-align: center;
}
a{
	text-decoration-line: none;
	color: black;
}
a:hover {
	text-decoration-line: underline;
}

.write_button{
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.write_button a {
	display: inline-block;
	min-width: 30px;
	margin-left: 10px;
	padding: 5px;
	border: 1px solid black;
	border-radius: 2px;
	font-size: 1.2rem;
}

.write_button a.on{
	background: white;	
	color: black;
}

</style>
</head>
<body>
<!-- when : ~하면 안에 내용 실행한다 -->
<!-- otherwise : when이 아니면 안에 내용 실행한다. -->
	<div class="board_title">
		<h2>게시판</h2>
		<p>글을 쓸수 있는 게시판입니다.</p>
	</div>
	<table>
	   <colgroup>
	      <col width="10%">
	      <col width="*">
	      <col width="15%">
	      <col width="15%">
	   </colgroup>
	   <thead>
		   <tr class="top">
		      <td>글번호</td>
		      <td>제 목</td>
		      <td>작성자</td>
		      <td>작성일</td>
		   </tr>
	   </thead>
	   <tbody>
	   		<c:choose>
		   		<c:when test="${list.size() eq 0}">
		   				<tr>
		   					<td colspan="4">
		   						글이 없습니다.
		   					</td>
		   				</tr>
		   		</c:when>
		   		<c:otherwise>
				   <c:forEach items="${list }" var="board">
				   <tr>
				      <td>${board.boardNum }</td>
				      <td><a href="boardDetail.do?boardNum=${board.boardNum }">${board.title }</a></td>
				      <td>${board.writer }</td>
				      <td>${board.createDate }</td>
				   </tr>
				   </c:forEach>
				 </c:otherwise>
		   </c:choose>
	   </tbody>
	</table>
	<div class="write_button">
		<a href="boardWriteForm.do" class="on">글쓰기</a>
	</div>
</body>
</html>
