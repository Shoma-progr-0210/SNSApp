<%@page import="entity.UserAccountEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userAccountEntity" scope="session"
class="entity.UserAccountEntity"/>
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/メッセージの入力</title>
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div>
    <form action="/SNSApp/control" method="POST" class="message">
      <input type="hidden" name="action_name" value="message">
<%= userAccountEntity.getChatName() %>のメッセージ：<br>
<textarea name="kanso" rows="5" cols="40"></textarea><br>
<input type="submit" value="Chatit"><input type="reset" value="リセット">
</form>
  </div>
</body>
</html>