<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/ログイン</title>
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="login" align="center">
    <form action="/SNSApp/control" method="POST" class="login">
      <input type="hidden" name="action_name" value="login">
      <h2>Login</h2>
      <p>
        <input type="text" id="userId" name="userId" placeholder="UserId">
      </p>
      <p>
        <input type="password" id="pass" name="pass" placeholder="Password">
      </p>
      <p>
        <input type="submit" value="Login" class="submit">
      </p>
      <br>
      <hr>
      <br>
    </form>
  </div>
</body>
</html>