<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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

.input{
	text-align: left;
	padding-left: 3px;
}

.input > input{
	width: 95%;
}

.input > textarea{
	resize: none;
}

.write_button{
	margin: 10px auto;
	text-align: center;
}

.input > textarea{
	width: 95%
}

a{
	text-decoration-line: none;
	color: black;
}
a:hover {
	text-decoration-line: underline;
}

.write_button > input{
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.write_button > input {
	display: inline-block;
	min-width: 30px;
	margin-left: 10px;
	padding: 5px;
	border: 1px solid black;
	border-radius: 2px;
	font-size: 1.2rem;
}

.write_button > input{
	background: white;	
	color: black;
}

</style>
</head>
<body>
	<div class="board_title">
		<h2>글 작성</h2>
	</div>

	<form action="regBoard.do" method="post">
	   <table class="board_write">
	      <tr>
	         <td class="top">제목</td>
	         <td class="input"><input type="text" name="title" required></td>
	      </tr>
	      <tr>
	         <td class="top">작성자</td>
	         <td class="input"><input type="text" name="writer" required></td>
	      </tr>
	      <tr>
	         <td class="top">내용</td>
	         <td class="input">
	            <textarea rows="5" cols="50" name="content"></textarea>
	         </td>
	      </tr>
	   </table>
	   <div class="write_button">
	 		<input type="submit" value="글등록">
	   </div>
	</form>
</body>
</html>
