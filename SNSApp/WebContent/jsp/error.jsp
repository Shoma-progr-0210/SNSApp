<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNSApp/エラー</title>
</head>
<body>
  <div id="top" class="top">
    <jsp:include page="/jsp/top.jsp" />
  </div>
    <div id="side" class="side">
    <jsp:include page="/jsp/SNSAppSide.jsp" />
  </div>
  <div id="error" align="center">
    <div class="error_title">
      <h2>エラー</h2>
    </div>
    <table>
      <tr>
        <td class="result">
          <h2>
            <%= request.getAttribute("errorMsg") %>
          </h2>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>