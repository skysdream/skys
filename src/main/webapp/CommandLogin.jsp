<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="bean.Message" %>
<%@ page import="bean.Applicant" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/Login.css"/>
		<script src="js/jquery.min.js"></script>
		<script type="text/javascript">
			function onblus() {
				var email = document.getElementById("email").value;
				$.ajax({
					/*contentType:'application/x-www-form-urlencoded',*/
					data:"email="+email,
					/*data_type:'text',*/
					type : 'post',
					url :'${pageContext.request.contextPath}/EmailValidateServlet',
					success: function (data) {
						if(data=="user right"){
							document.getElementById("info").innerHTML = "right";
						}
						else{
							document.getElementById("info").innerHTML = "error";
						}
					}
				})
			}
		</script>
	</head>
	<body>
		<iframe src="Head.html" width="100%" height="200px" scrolling="no" frameborder="0"></iframe>
		<div class="all">
			<div class="login">
				<h1>Login</h1>
				<form method="post" action="/objectdesign/ApplicantLoginServlet">
					<input  type="text" name="email" id="email" required="required" style="height: 30px; margin-top: 40px;margin-right: 0" placeholder="邮箱" name="u" onblur="onblus()"></input>
					<span style="margin:0px;color: red;font-size: small;" id="info"></span>
					<input type="password" name="password" id="password" required="required" style="height: 30px;" placeholder="密码" name="p"></input>
					<button class="but" type="submit">登录</button>
				</form>
				<span style="color: blue; font-size: small; position: absolute; left: 30px; margin: 20px; ">注册新用户</span>
				<span style="color: blue; font-size: small;position: absolute; left:240px ; margin: 20px;">欢迎使用本系统</span>
			</div>
		</div>
		<iframe src="buttom.html" width="100%" height="200px" scrolling="no" frameborder="0"></iframe>
	</body>
</html>