<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../home/header.jsp" />
<div align="center">
	<div><h1>로 그 인</h1></div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아 이 디</th>
						<td width="200">
							<input type="email" id="id" name="id" required="required" placeholder="Enter Your email...">
						</td>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<td width="200">
							<input type="password" id="password" name="password" required="required" placeholder="Enter Your Password..">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="reset" value="취 소">&nbsp;&nbsp;&nbsp;
				<input type="submit" value="로그인">
			</div>
		</form>
	</div>	
</div>
</body>
</html>