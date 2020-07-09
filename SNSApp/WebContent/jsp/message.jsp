<%@page import="entity.UserAccountEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userAccountEntity" scope="session"
  class="entity.UserAccountEntity" />
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/メッセージの入力</title>
<link rel="stylesheet" type="text/css" href="./css/grid.css">
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="side" class="side">
    <jsp:include page="/jsp/SNSAppSide.jsp" />
  </div>
  <div id="message" class="main">
    <form action="/SNSApp/control" method="POST" >
      <input type="hidden" name="action_name" value="sendMessage">
      <%= userAccountEntity.getChatName() %>のメッセージ：<br>
      <textarea name="message" rows="8" cols="25" maxlength="200"></textarea>
      <br> <input type="submit" value="メッセージを送信"><input
        type="reset" value="リセット">
    </form>
  </div>
</body>
</html>