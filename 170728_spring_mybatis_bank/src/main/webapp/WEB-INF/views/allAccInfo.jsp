<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<caption>전체 계좌 조회</caption>
<tr class="header">
		<th align="center" width="80">계좌번호</th>
		<th align="center" width="320">이름</th>
		<th align="center" width="100">잔액</th>
	</tr>
	<c:forEach items="${accountList}" var="account">
		<tr class="record">
			<td align="center">${account.id}</td>
			<td align="left">${account.name}</td>
			<td align="right">${account.balance}원</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>