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
            /* font-family: Libre Baskerville,Arial,malgun gothic,맑은고딕,NanumGothic,Apple SD Gothic Neo,dotum,돋움,sans-serif; */
            /* font-family: serif; */
            color: black;
            text-decoration: none;
            margin: 0 auto;
            font-size: 9pt;
            padding: 1%;
        }

        h2 {
        	margin-top: 2%;
            font-size: 12pt;
        }

        input[type=submit] {
            float: center;
            margin: 2% 0 0 1%;
            padding: 0px;
            line-height: 26px;
            background: rgb(238, 236, 225);
            text-transform: uppercase;
            text-align: center;
            font-size: 9pt;
            letter-spacing: 1px;
            width: 80px;
            height: 32px;
            /* width: 120px;
            height: 40px; */
            border: 1px #ababab solid;
            border-radius: 2px;
        }

        input[type=button] {
            float: center;
            margin: 2% 0 0 0;
            padding: 0px;
            line-height: 26px;
            background: rgb(238, 236, 225);
            text-transform: uppercase;
            text-align: center;
            font-size: 9pt;
            letter-spacing: 1px;
            width: 268px;
            height: 32px;
            /* width: 120px;
            height: 40px; */
            border: 1px #ababab solid;
            border-radius: 2px;
        }

        input[type=text] {
            height: 26px;
            line-height: 22px;
            padding: 2px 4px;
            border: 1px solid #d5d5d5;
            font-size: 9pt;
        }
    </style>
</head>

<body>
    <script type="text/javascript" src="alert.js"></script>
    <h2>아이디 중복 확인</h2><br>
    <form action="id_chk" method="get" name="idChkForm">
        아이디 &emsp;<input type="text" name="id" value="${id }" size="15px"> <input type="submit" value="중복체크"> <br><br>
        <c:if test="${result==1 }">
            <script type="text/javascript">
                opener.document.idChkForm.iid.value = "";
            </script>
            ${id }는 이미 사용 중인 아이디입니다.
        </c:if>
        <c:if test="${result==2 }">
            ${id } 는 사용 가능합니다.<br>
            <input type="button" value="아이디 사용" class="cancle" onclick="idOk()">
        </c:if>
        <c:if test="${result==3 }">
            아이디를 입력하세요.
        </c:if>
    </form>
</body>

</html>