<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	font-family: arial, "돋움";
	color: black;
	text-decoration: none;
	margin: 0 auto;
	/* font-family: Libre Baskerville,Arial,malgun gothic,맑은고딕,NanumGothic,Apple SD Gothic Neo,dotum,돋움,sans-serif; */
	/* position: relative; */
	/* width: 1360px; */
	/* padding: 0; */
}

body {
	min-width: 1250px;
}

section {
	width: 1050px;
}

header {
	height: 20px;
	line-height: 80px;
	padding: 15px 100px;
	color: white;
	background-color: rgb(238, 236, 225);
}

nav {
	float: right;
}

a:hover {
	/* 마우스를 올려놨을 때 */
	color: gray;
}

#head {
	margin: 60px 0 0 5px;
	letter-spacing: 1px;
}

table {
	font-size: 9pt;
	letter-spacing: 1px;
	margin-top: 15px;
	padding: 0px;
	text-align: center;
	border: 1px #ababab solid;
	border-spacing: 1px;
	border-collapse: collapse;
	display: table;
}

.sub {
	font-size: 9pt;
	background-color: rgb(238, 236, 225);
}

td {
	text-align: center;
}

th, td {
	padding: 10px;
}

span {
	font-size: 9pt;
}

.menu {
	font-size: 10pt;
}

.head {
	font-size: 9pt;
}

input[type=button] {
	float: right;
	margin: 2% 0 0 0;
	padding: 0px;
	width: 140px;
	height: 40px;
	border-radius: 2px;
	line-height: 26px;
	background: rgb(238, 236, 225);
	border: 1px #ababab solid;
	text-transform: uppercase;
	text-align: center;
	font-size: 9pt;
	letter-spacing: 1px;
}

/* footer {
            height: 80px;
            clear: both;
            background-color: rgb(238, 236, 225);
        } */
</style>
</head>

<body>
	<div class="mainP">
		<header>
			<h1></h1>
		</header>
		<nav>
			<c:if test="${empty sessionScope.id }">
				<!-- 로그인된 아이디가 없으면 -->
				<span class="menu">GUEST&emsp;</span>
				<span class="menu"><a href="login_form.jsp">LOGIN</a>&emsp;</span>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<span class="menu">${sessionScope.name }님 &emsp;</span>
				<span class="menu"><a href="logout">LOGOUT</a>&emsp;</span>
			</c:if>

			<span class="menu"><a href="join_form.jsp">JOIN</a>&emsp;</span> <span
				class="menu"><a href="list">Q&A</a>&emsp;</span>

		</nav>
		<section id="list">
			<div id="head">
				<span class="head"><a hrer="list">Q&A</a></span>
			</div>
			<table border=1 width=100%>
				<tr class="sub">
					<td width=70>NO</td>
					<td width=auto>TITLE</td>
					<td width=100>WRITER</td>
					<td width=90>DATE</td>
					<td width=80>HITS</td>
				</tr>
				<c:forEach items="${boardList }" var="i">
					<tr>
						<td>${i.num }</td>
						<td><a href="identification?num=${i.num }&id=${i.id }">${i.title }</a></td>
						<td>${i.name }</td>
						<td>${i.day }</td>
						<td></td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${empty sessionScope.id }">
				<!-- 로그인된 아이디가 없으면 -->
				<input type="button" value="WRITE">
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<!-- 로그인된 아이디가 있으면-->
				<a href="write_form.jsp"><input type="button" value="WRITE"></a>
			</c:if>
		</section>

	</div>
	<footer> </footer>
</body>

</html>