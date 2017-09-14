<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div data-role="page" id="pageone">
  <div data-role="header">
    <h1>전체계좌조회</h1>
  </div>
  
  <div data-role="main" class="ui-content">
    <table data-role="table" data-mode="columntoggle" class="ui-responsive ui-shadow" id="myTable">
      <thead>
        <tr>
          <th data-priority="1">계좌번호</th>
          <th data-priority="2">계좌주</th>
          <th data-priority="3">잔액</th>
        </tr>
      </thead>
      <tbody>
       
        <c:forEach items="${accountList}" var="account">
		<tr class="record">
			<td align="center">${account.id}</td>
			<td align="left">${account.name}</td>
			<td align="right">${account.balance}원</td>
		</tr>
	</c:forEach>

      </tbody>
    </table>
  </div>

  <div data-role="footer">
    <h1>Footer Text</h1>
  </div>
</div> 

</body>
</html>