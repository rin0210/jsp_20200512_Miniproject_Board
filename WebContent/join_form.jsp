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
	font-family: arial, "돋움";
	/* font-family: Libre Baskerville,Arial,malgun gothic,맑은고딕,NanumGothic,Apple SD Gothic Neo,dotum,돋움,sans-serif; */
	/* font-family: serif; */
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
	background-color: rgb(238, 236, 225);
}

nav {
	float: right;
	font-size: 10pt;
}

#head {
	display: inline-block;
	margin: 100px 0 0 267px;
	font-size: 9pt;
	letter-spacing: 1px;
}

table {
	margin-top: 15px;
	width: 520px;
	padding: 0px;
	border: 1px #ababab solid;
	border-collapse: collapse;
	border-spacing: 1px;
}

tr {
	height: 40px;
	background-color: rgb(238, 236, 225);
}

.formTxt {
	padding: 20px;
	font-size: 9pt;
}

.formEle {
	padding-left: 20px;
	text-align: left;
}

input[type=text], [type="password"] {
	height: 25px;
	line-height: 22px;
	padding: 2px 4px;
	border: 1px solid #d5d5d5;
	font-size: 9pt;
}

input[type=submit] {
	font-size: 9pt;
	letter-spacing: 1px;
	width: 140px;
	height: 40px;
	line-height: 32px;
	display: inline-block;
	margin: 2% 0 0 645px;
	padding: 0px;
	background: rgb(238, 236, 225);
	border: 1px solid #ababab;
	border-radius: 2px;
	text-transform: uppercase;
	text-align: center;
}

input[type=button] {
	font-size: 9pt;
	letter-spacing: 1px;
	width: 80px;
	height: 30px;
	line-height: 32px;
	display: inline-block;
	padding: 0px;
	background: white;
	border: 1px solid #ababab;
	border-radius: 2px;
	text-transform: uppercase;
	text-align: center;
}
</style>
</head>

<body>
	<header> </header>
	<nav>
		<span>GUEST&emsp;</span> <span><a href="login_form.jsp">LOGIN</a>&emsp;</span>
		<span><a href="join_form.jsp">JOIN</a>&emsp;</span> <span><a
			href="list">Q&A</a>&emsp;</span>
	</nav>
	<section>
		<form name="joinForm" action="join" method=post>

			<div>
				<span id="head">REGISTER</span>
			</div>
			<table border=1 align=center class="txt">
				<tr>
					<td class="formTxt" width=50><span>아이디</span></td>
					<td class="formEle"><input type="text" size="42" name="iid"
						maxlength="10">&emsp;&nbsp;<input type="button"
						value="중복체크" onclick="idCheck()"><input type="hidden"
						name="idChk" size="20"></td>

				</tr>
				<tr>
					<td class="formTxt"><span>비밀번호</span></td>
					<td width=300 class="formEle"><input type="password" size="58"
						name="ipwd" maxlength="10"><span></span></td>
				</tr>
				<tr>
					<td class="formTxt"><span>이름</span></td>
					<td width=300 class="formEle"><input type="text" size="58"
						name="iname" maxlength="10"><span></span></td>
				</tr>

			</table>
			<div>
				<span><input type="submit" value="SUBMIT"
					onclick="return joinCheck()"></span>
			</div>
		</form>
	</section>
	<script type="text/javascript" src="alert.js"></script>
</body>
</html>