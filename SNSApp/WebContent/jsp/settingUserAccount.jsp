<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userAccountEntity" scope="session"
  class="entity.UserAccountEntity" />
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/アカウント情報</title>
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="settingSide" class="settingSide">
    <jsp:include page="/jsp/settingSide.jsp" />
  </div>
  <form action="/SNSApp/control" method="POST" class="userAccount">
    <input type="hidden" name="action_name" value="updateUserAccount">
    <table>
      <tr>
        <th>アカウント情報</th>
      </tr>
      <tr>
        <td><input type="text" name="userNo"
          value="<%=userAccountEntity.getUserNo()%>"></td>
      </tr>
      <tr>
        <td><input type="text" name="familyName"
          value="<%=userAccountEntity.getFamilyName()%>"></td>
      </tr>
      <tr>
        <td><input type="text" name="firstName"
          value="<%=userAccountEntity.getFirstName()%>"></td>
      </tr>
      <tr>
        <td><input type="text" name="birthday"
          value="<%=userAccountEntity.getBirthday()%>"></td>
      </tr>
      <tr>
        <td><input type="text" name="chatName"
          value="<%=userAccountEntity.getChatName()%>"></td>
      </tr>
    </table>
    <br> <input type="submit" value="アカウント情報変更"> <input
      type="reset" value="リセット">
  </form>
</body>
</html>