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
	margin: 100px 0 0 375px;
	font-size: 9pt;
	letter-spacing: 1px;
}

table {
	margin-top: 15px;
	width: 300px;
	height: 300px;
	background-color: rgb(238, 236, 225);
	padding: 15px;
	border: 1px #ababab solid;
}

tr {
	height: 40px;
	font-size: 9pt;
	/* text-align: left; */
	/* background-color: rgb(238, 236, 225); */
}

.formEle {
	padding-left: 0px;
	text-align: left;
}

input[type=submit] {
	float: center;
	margin: 2% 0 0 375px;
	padding: 0px;
	line-height: 26px;
	background: rgb(238, 236, 225);
	text-transform: uppercase;
	text-align: center;
	font-size: 9pt;
	letter-spacing: 1px;
	width: 300px;
	height: 42px;
	/* width: 120px;
            height: 40px; */
	border: 1px #ababab solid;
	border-radius: 2px;
}

input[type=text], [type=password] {
	height: 40px;
	line-height: 22px;
	padding: 2px 4px;
	border: 1px solid #d5d5d5;
	font-size: 9pt;
}
</style>
</head>

<body>
	<script type="text/javascript" src="alert.js"></script>
	<header>
		<h1></h1>
	</header>
	<nav>
		<span>GUEST&emsp;</span> <span><a href="login_form.jsp">LOGIN</a>&emsp;</span>
		<span><a href="join_form.jsp">JOIN</a>&emsp;</span> <span><a
			href="list">Q&A</a>&emsp;</span>
	</nav>
	<section>
		<div class="mainP">
			<form name="loginForm" action="login_chk" method=post>
				<div>
					<span id="head">LOGIN</span>
				</div>
				<table align=center class="txt">
					<tr>
					</tr>
					<tr>
						<td class="formTxt"><span>아이디</span></td>
					</tr>
					<tr>
						<td class="formEle"><input type="text" size="35" name="iid"
							maxlength="10"></td>
					</tr>

					<tr>
						<td class="formTxt"><span>비밀번호</span></td>
					</tr>
					<tr>
						<td class="formEle"><input type="password" size="35"
							name="ipwd" maxlength="10"></td>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
				</table>
				<div>
					<span><input type="submit" value="LOGIN"
						onclick="return loginCheck()"></span>

				</div>
			</form>
		</div>
	</section>
</body>
</html>