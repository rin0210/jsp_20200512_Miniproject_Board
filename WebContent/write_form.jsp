<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=<device-width>, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<style>
* {
	/* font-family: Libre Baskerville,Arial,malgun gothic,"맑은고딕",NanumGothic,Apple SD Gothic Neo,dotum,"돋움",sans-serif; */
	font-family: arial, "돋움";
	color: black;
	text-decoration: none;
	margin: 0 auto;
}

a:hover {
	/* 마우스를 올려놨을 때 */
	color: gray;
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
	font-size: 10pt;
}

#head {
	display: inline-block;
	margin: 100px 0 0 225px;
	font-size: 9pt;
	letter-spacing: 1px;
}

table {
	margin-top: 15px;
	text-align: center;
	width: 400px;
	background-color: rgb(238, 236, 225);
	padding: 0px;
	border: 1px #ababab solid;
	border-collapse: collapse;
	border-spacing: 1px;
}

tr {
	height: 40px;
	/* background-color: rgb(238, 236, 225); */
}

.formTxt {
	padding: 20px;
	font-size: 9pt;
}

.formEle {
	padding-left: 10px;
	text-align: left;
}

.formEle_option {
	border: 1px solid #d5d5d5;
	height: 30px;
}

input[type=text], [type=password] {
	height: 30px;
	line-height: 22px;
	padding: 2px 4px;
	border: 1px solid #d5d5d5;
	font-size: 10pt;
}

textarea {
	border: 1px solid #d5d5d5;
	margin: 10px 10px 10px 0;
	resize: none;
}

.btn_area {
	float: right;
	margin: 2% 222px 0 0;
}

input[type=submit], [type=button] {
	font-size: 9pt;
	letter-spacing: 1px;
	width: 140px;
	height: 40px;
	line-height: 32px;
	margin-left: 10px;
	display: inline-block;
	padding: 0px;
	background: rgb(238, 236, 225);
	border: 1px solid #ababab;
	border-radius: 2px;
	text-transform: uppercase;
	text-align: center;
}
</style>
</head>

<body>
<script type="text/javascript" src="alert.js"></script>
	<header>
		<h1></h1>
	</header>
	<nav>
		<c:if test="${empty sessionScope.id }">
			<!-- 로그인된 아이디가 없으면 -->
			<span>GUEST&emsp;</span>
			<span><a href="login_form.jsp">LOGIN</a>&emsp;</span>
		</c:if>
		<c:if test="${not empty sessionScope.id }">
			<span>${sessionScope.name }님 &emsp;</span>
			<span><a href="logout">LOGOUT</a>&emsp;</span>
		</c:if>

		<span><a href="join_form.jsp">JOIN</a>&emsp;</span> <span><a
			href="list">Q&A</a>&emsp;</span>
	</nav>
	<section>
		<div class="mainP">
			<form action="write" method=post name="writeForm">
				<div>
					<span id="head">WRITE</span>
				</div>
				<table border=1; align=center class="txt" r>

					<tr>
						<td class="formTxt" width=100><span>제목</span></td>
						<td class="formEle" colspan=4><select class="formEle_option"
							name="ititle">
								<option><span>상품문의</span></option>
								<option><span>배송문의</span></option>
								<option><span>재입고문의</span></option>
								<option><span>교환/반품문의</span></option>
								<option><span>기타문의</span></option>
						</select></td>
					</tr>
					<tr>
						<td class="formTxt" width=100><span>이름</span></td>
						<td class="formEle" colspan=3><input type="text" size="20"
							name="iname" maxlength="8" readonly="readonly"
							value="${sessionScope.name }"></td>
					</tr>
					<tr>
						<td colspan="2" class="formEle"><textarea name="ibody"
								cols="80" rows="19"></textarea></td>
					</tr>
					<tr>
						<td class="formTxt" width=100><span>비밀번호</span></td>
						<td class="formEle" colspan=3><input type="password"
							size="20" name="ipwd" maxlength="8"></td>
					</tr>
				</table>
				<div class="btn_area">
					<span class="btn1"><a href="list"><input type="button"
							value="LIST"></a></span> <span class="btn2"><input
						type="submit" value="OK" onclick="return writeCheck()"> </span>
				</div>
			</form>
		</div>
	</section>
</body>
</html>