<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	String selPage = request.getParameter("selPage");
	String selPage = (String)request.getAttribute("selPage");
	if(selPage==null)
		selPage = "login_Form";
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>여기는브랜치테스트입니다.</title>
<style type="text/css">
*{margin:0;padding:0;}
   body { font : 15px "굴림", Gulim ;width:300px;}
   h1{font-size: 300%; text-align: center;vertical-align: middle; padding-top: 30px;}
   #header {width:600px; height:100px; background: #FFBB00; position:relative;}
   h1+p {position:absolute; right:20px; top:70px; }
   a { text-decoration: none;}
   #menu {width:200px; height:500px; background: #FF5E00;}
   #menu dl {padding:30px;}
   #menu dl dd {padding:5px;}
   #menu dl dd a {color: #fff;}
   #content {position:absolute; left:200px;top:100px; width: 400px; height:500px; background: #FAF4C0;}
	table {margin: 30px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>
<div id="container">
<jsp:include page="top.jsp"></jsp:include>
	<div id="menu">
		<dl>
			<dd><a href="makeAccount.bk">계좌개설</a></dd>
			<dd><a href="deposit.bk">입금</a></dd>
			<dd><a href="withdraw.bk">출금</a></dd>
			<dd><a href="accInfo.bk">계좌조회</a></dd>
			<dd><a href="allAccInfo.bk">전체계좌조회</a></dd>
		</dl>
	</div>
	<div id="content">
		<jsp:include page='<%=selPage+".jsp" %>'/>
	</div>
</div>
</body>
</html>