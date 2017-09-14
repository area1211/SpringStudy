<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="jsp_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="make">
<form:form modelAttribute="account" action="makeAccountAction.bk" method="post">
<table border="0">
<caption>계좌개설</caption>
<tr><th scope="row">계좌번호</th><td><input type="text" name="id"/></td></tr>
<tr><th scope="row">이름</th><td><input type="text" name="name"/></td></tr>
<tr><th scope="row">입금액</th><td><input type="text" name="balance"/></td></tr>
<tr><td colspan="2" style="text-align: right;"><input type="submit" value="개설"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>