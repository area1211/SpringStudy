<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="pageone">
  <div data-role="main" class="ui-content">
    <h2 style="text-align:center;">Lectopia Bank</h2>
    <ul data-role="listview" data-inset="true">    
      <li data-icon="plus"><a href="makeAccountAction.mobile">계좌개설</a></li>
      <li data-icon="minus"><a href="#">입금하기</a></li>
      <li data-icon="delete"><a href="#">출금하기</a></li>
      <li data-icon="location"><a href="accInfo.mobile">계좌조회</a></li>   
      <li data-icon="false"><a href="allAccInfo.mobile">전체계좌조회ㅁㅇㄴㅇㅁㅇㅁㄴㅇㅁㄴ</a></li>
    </ul>
  </div>
</div> 
</body>
</html>
