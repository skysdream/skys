<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/MyCard.css"/>
	</head>
	<body>
	<p>当前在线人数为：${applicationScope.count}
		<a href="logount.jsp">退出系统</a>
	</p>
		<iframe src="Head.html" width="100%" height="200px" scrolling="no" frameborder="0"></iframe>
		<div class="c1">
			<div class="c2" style="height: 120px;width: 240px">
				<span>姓名：${sessionScope.SESSION_MESSAGE.worker_Name}</span><br />
				<span>性别：${sessionScope.SESSION_MESSAGE.worker_sex}</span><br />
				<span>职位：${sessionScope.SESSION_MESSAGE.worker_position}</span><br />
				<span>邮箱：${sessionScope.SESSION_APPLICANT.applicant_Email}</span><br />

			</div>
			<div class="picture">
				<img src="${appPath}/images/${sessionScope.SESSION_MESSAGE.worker_Picture}">
			</div>
			<div class="c3">
				<span>公司名称：中国新东方烹饪有限公司</span><br/>
				<span>公司部门：${sessionScope.SESSION_MESSAGE.session_Id}</span><br />
				<span>地址：${sessionScope.SESSION_MESSAGE.worker_Site}</span><br />
				<span>手机：15211471156</span><br />
			</div>
		</div>
		<form action="${pageContext.request.contentType}/objectdesign/QRCardServlet" method="get">
			<input type="submit" value="生成我的二维码" id="mycard" style="text-align: center;">
		</form>
		<iframe src="buttom.html" width="100%" height="200px" scrolling="no" frameborder="0"></iframe>
	</body>
</html>