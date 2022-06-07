<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body class="login_body">
  <div class="header">
    <h1 class="site_logo">ECサイト</h1>
  </div>

  <div class="login_form">
    <img src="./images/logo.png" class="login_logo">
    <p class="error">
    <c:if test="${not empty msg}">
          	<p>${msg}</p>
  		  </c:if>
    </p>

    <form:form action="login" modelAttribute="login" method="get">
      <fieldset>
        <div class="cp_iptxt">
          <form:input class="base_input"  path="logId" placeholder="ID"/><br>
          <form:errors path="logId" cssStyle="color: red"/><br>
          <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
        </div>

        <div>
          <form:input class="base_input" path="pass" placeholder="PASS"/><br>
          <form:errors path="pass" cssStyle="color: red"/><br>
        </div>
      </fieldset>
      <form:button class="logout_btn" name="login">ログイン</form:button>
      <form:button class="logout_btn" name="insert">新規登録</form:button>
    </form:form>
  </div>
</body>
</html>