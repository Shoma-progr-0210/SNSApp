<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userAccountEntity" scope="session"
  class="entity.UserAccountEntity" />
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/アカウント情報</title>
<link rel="stylesheet" type="text/css" href="./css/grid.css">
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="settingSide" class="side">
    <jsp:include page="/jsp/settingSide.jsp" />
  </div>
  <div id="userAccount" class="main">
    <div class="main_container">
      <form action="/SNSApp/control" method="POST">
        <input type="hidden" name="action_name" value="updateUserAccount">
        <table>
          <tr>
            <th></th>
            <th>アカウント情報</th>
          </tr>
          <tr>
            <td>ユーザNo</td>
            <td><input type="text" name="userNo"
              value="<%=userAccountEntity.getUserNo()%>" disabled></td>
          </tr>
          <tr>
            <td>苗字</td>
            <td><input type="text" name="familyName"
              value="<%=userAccountEntity.getFamilyName()%>"></td>
          </tr>
          <tr>
            <td>名前</td>
            <td><input type="text" name="firstName"
              value="<%=userAccountEntity.getFirstName()%>"></td>
          </tr>
          <tr>
            <td>生年月日</td>
            <td><input type="date" name="birthday"
              pattern="\d{4}-?\d{2}-?\d{2}"
              value="<%=userAccountEntity.getBirthday()%>"></td>
          </tr>
          <tr>
            <td>チャットネーム</td>
            <td><input type="text" name="chatName"
              value="<%=userAccountEntity.getChatName()%>"></td>
          </tr>
        </table>
        <br> <input type="submit" value="アカウント情報変更"> <input
          type="reset" value="リセット">
      </form>
    </div>
  </div>
</body>
</html>