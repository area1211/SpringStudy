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
<div id="withdraw">
<form:form modelAttribute="depositionInfo" action="withdrawAction.action" method="post">
	<spring:hasBindErrors name="depositionInfo">
		<font color="red"><c:forEach items="${errors.globalErrors}"
			var="error">
			<spring:message code="${error.code}"  />
		</c:forEach> </font>
	</spring:hasBindErrors>
<table border="0">
<caption>출금</caption>
<tr><th scope="row">계좌번호</th><td><input type="text" name="id"/></td></tr>
<tr><td colspan="2"><font color="red"><form:errors path="id"/></font></td></tr>
<tr><th scope="row">출금액</th><td><input type="text" name="money"/></td></tr>
<tr><td colspan="2"><font color="red"><form:errors path="money"/></font></td></tr>
<tr><td colspan="2" style="text-align: right;"><input type="submit" value="출금"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>