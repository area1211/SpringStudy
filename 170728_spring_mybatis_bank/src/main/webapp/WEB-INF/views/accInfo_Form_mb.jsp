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
  <h1>계좌 조회123</h1>
  <script>
            $(function(){
                $('#camera').change(function(e){
                    $('#pic').attr('src', URL.createObjectURL(e.target.files[0]));
                });
            });
            </script>
        <input type="file" id="camera" name="camera" capture="camera" accept="image/*" />
        <br/>
        <img id="pic" style="width:100%;" />
  <script>
            $(function(){
                $('#camcorder').change(function(e){
                    $('#mov').attr('src', URL.createObjectURL(e.target.files[0]));
                });
            });
        </script>
        <input type="file" id="camcorder" name="camcorder" capture="camcorder" accept="video/*" />
        <br/>
        <video id="mov" width="100%" autoplay="yes" controls="true" ></video>


  </div>

  <div data-role="main" class="ui-content">
    <form:form method="post" action="accInfo.mobile" autocomplete="off">
      <div class="ui-field-contain">
        <label for="id">계좌번호</label>
        <input type="text" name="id" id="id">
      </div>
      <input type="submit"  value="조회하기">
    </form:form>
    
	<c:if test="${!empty account}">
		<h1>조회결과</h1>
		<div>
			<table>
				<tr><th>계좌번호</th><td>${account.id}</td></tr>
				<tr><th>이름</th><td>${account.name}</td></tr>
				<tr><th>잔액</th><td>${account.balance}</td></tr>
			</table>
		</div>
	</c:if>
	<c:if test="${empty account}">
		<h1>조회결과</h1>
		<div>
			해당 계좌번호가 존재하지 않습니다.
		</div>
	</c:if>
  </div>
</div>


</body>
</html>