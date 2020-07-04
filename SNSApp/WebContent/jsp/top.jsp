<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userEntity" scope="session" class="entity.UserEntity" />
<div class="top_title" align="center">
  <h1>SNSApp</h1>
</div>
<%
  if (userEntity.getUserId() != null){
  %>
<div class="login_user_area" align="right">
  Login User : <span class="login_user_id"> <jsp:getProperty
      property="userId" name="userEntity" />
  </span>
</div>
<%
        }
        %>