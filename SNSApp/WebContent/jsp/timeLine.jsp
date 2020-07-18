<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.MessageEntity"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
<link rel="stylesheet" type="text/css" href="./css/grid.css">
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="side" class="side">
    <jsp:include page="/jsp/SNSAppSide.jsp" />
  </div>
  <div id="timeLine" class="main">
    <div class="main_container">
      <%DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); %>
      <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); %>
      <h3>
        タイムライン(更新日時：<%=LocalDateTime.now().format(dtf) %>)
      </h3>
      <div class="table_container">
        <table class="message">
          <tr>
            <th>メッセージ</th>
          </tr>
          <% for (MessageEntity messageEntity : messageEntityList){ %>
          <tr>
            <td>

              <table class="message_text">
                <tr>
                  <th><%=messageEntity.getChatName() %> <font size="1">投稿日時：<%=sdf.format(messageEntity.getCreateDT()) %>
                      更新日時：<%=sdf.format(messageEntity.getUpdateDT()) %></font></th>
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
    </div>
  </div>
</body>
</html>