<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="jsp_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

</head>
<body>
<div data-role="page">
  <div data-role="header">
  <h1>계좌 개설</h1>
  </div>

  <div data-role="main" class="ui-content">
    <form:form modelAttribute="account" method="post" action="makeAccountAction.mobile" autocomplete="off">
      <div class="ui-field-contain">
        <label for="id">계좌번호</label>
        <input type="text" name="id" id="id">       
        <label for="name">이름</label>
        <input type="text" name="name" id="name">
        <label for="balance">금액</label>
        <input type="text" name="balance" id="balance" placeholder="계좌 개설을 위한 초기 금액...">
      </div>
      <input type="submit"  value="개설하기">
    </form:form>
  </div>
</div>

</body>
</html>