<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.MessageEntity"%>
<%@page import="java.text.SimpleDateFormat" %>
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
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
  <div id="side" class="side">
    <jsp:include page="/jsp/SNSAppSide.jsp" />
  </div>
  <div align="center">
    <%DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); %>
    <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); %>
    <h3>
      タイムライン(更新日時：<%=LocalDateTime.now().format(dtf) %>)
    </h3>
    <table>
      <tr>
        <th>メッセージ</th>
      </tr>
      <% for (MessageEntity messageEntity : messageEntityList){ %>
      <tr>
        <td>

          <table style="border-radius: 5px; border: 1px blue solid;">
            <tr>
              <th style="border-style: none;"><%=messageEntity.getUserNo() %>
                <font size="1">投稿日時：<%=sdf.format(messageEntity.getCreateDT()) %>
                  更新日時：<%=sdf.format(messageEntity.getUpdateDT()) %></font></th>
            </tr>
            <tr>
              <td style="border-style: none;"><%=messageEntity.getMessage() %></td>
            </tr>
          </table>

        </td>
      </tr>
      <%} %>
    </table>
  </div>
</body>
</html>