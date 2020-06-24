<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.MessageEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="messageEntityList" scope="request"
  class="java.util.ArrayList"
  type="java.util.ArrayList<entity.MessageEntity>" />
<jsp:useBean id="userAccountEntity" scope="session"
  class="entity.UserAccountEntity" />
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/タイムライン</title>
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="side" class="side">
    <jsp:include page="/jsp/SNSAppSide.jsp" />
  </div>
  <div align="center">
    <h3>
      タイムライン(更新日時：<%=LocalDateTime.now() %>)
    </h3>
    <table>
      <tr>
        <th>メッセージ</th>
      </tr>
      <% for (MessageEntity messageEntity : messageEntityList){ %>
      <tr>
        <td>

          <table border="none">
            <tr>
              <th><%=messageEntity.getUserNo() %>
              投稿日時：<%=messageEntity.getCreateDT() %>
              更新日時：<%=messageEntity.getUpdateDT() %></th>
            </tr>
            <tr>
              <td><%=messageEntity.getMessage() %></td>
            </tr>
          </table>

        </td>
      </tr>
      <%} %>
    </table>
  </div>
</body>
</html>