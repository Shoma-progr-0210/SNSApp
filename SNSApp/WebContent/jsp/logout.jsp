<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp</title>
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="logout" class="logout" align="center">
    <p>ログアウトしました</p>
    <a href="/SNSApp/jsp/login.jsp">ログイン画面へ</a> <br>
    <hr>
    <br>
  </div>
</body>
</html>