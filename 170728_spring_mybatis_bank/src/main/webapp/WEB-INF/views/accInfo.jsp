<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="bean.*" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border=1>
<caption>계좌 조회</caption>
<tr><th scope="row">계좌번호</th><td>${account.id}</td></tr>
<tr><th scope="row">이름</th><td>${account.name}</td></tr>
<tr><th scope="row">잔액</th><td>${account.balance}</td></tr>
<tr><th scope="row">계좌구분</th>
<td>

<tr><th scope="row">등급</th><td></td></tr>

</table>

</body>
</html>