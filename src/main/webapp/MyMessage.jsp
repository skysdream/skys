<%@ page import="bean.Message" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/font-awesome.css" />
		<link rel="stylesheet" href="css/MyMessage.css" />
		<script type="text/javascript" src="js/modifyMessage.js"></script>
		<%
				Message messageInfo = (Message) request.getAttribute("messageInfo");
		%>
		<script src="js/jquery.min.js"></script>
	</head>
	<body>
		<p>当前在线人数为：${applicationScope.count}
			<a href="logount.jsp">退出系统</a>
		</p>
		<iframe src="Head.html" width="100%" height="200px" scrolling="no" frameborder="0"></iframe>
		<div class="contain" style="width: 800px">
			<div class="head">
				<%if(messageInfo!=null){%>
				<img src="${appPath}/images/<%=messageInfo.getWorker_Picture()%>">
				<%}else{%>
				<img src="${appPath}/images/${sessionScope.SESSION_MESSAGE.worker_Picture}">
				<%}%>
				<form action="${pageContext.request.contentType}/objectdesign/ChangePictureServlet" method="post" enctype="multipart/form-data">
					<input type="file" value="跟换头像" id="headshot" name="headshot" style="position: absolute ;left:6%;top:125px">
					<input name="submit" type="submit" class="save1" value="保存" style="position: absolute;left: 20%;top: 50px;">
					<input name="reset" type="reset" class="cancel2" value="取消"style="position: absolute;left: 20%;top: 100px;">
				</form>
			</div>
			<div class="body" style="position: relative;top: 20%;left: 34%">
				<div class="applicant">
					<h2>账号信息</h2>
					<ul id="account">
						<li id="id" name="id">id:${sessionScope.SESSION_APPLICANT.applicant_Id}<i class="fa fa-pencil-square-o"></i></li>
						<li id="name" name="name">昵称:${sessionScope.SESSION_APPLICANT.applicant_Name}<a><i class="fa fa-pencil-square-o"></i></a></li>
						<li id="email" name="email">邮箱:${sessionScope.SESSION_APPLICANT.applicant_Email}<a><i class="fa fa-pencil-square-o"></i></a></li>
					</ul>
				</div>
				<div class="worker">
					<h2>工作信息</h2>
					<ul>
						<li >工号:	<span id="worker_id">${sessionScope.SESSION_MESSAGE.worker_Id}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >账号id:	<span id="applicant_id">${sessionScope.SESSION_MESSAGE.applicant_Id}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >姓名:   <span id="worker_name">${sessionScope.SESSION_MESSAGE.worker_Name}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >性别:   <span id="worker_sex">${sessionScope.SESSION_MESSAGE.worker_sex}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >工龄:   <span id="worker_age">${sessionScope.SESSION_MESSAGE.worker_Age}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >部门:   <span id="worker_section">${sessionScope.SESSION_MESSAGE.session_Id}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >职位:   <span id="worker_position">${sessionScope.SESSION_MESSAGE.worker_position}</span><i class="fa fa-pencil-square-o"></i></li>
						<li >地址:	<span id="worker_site">${sessionScope.SESSION_MESSAGE.worker_Site}</span><i class="fa fa-pencil-square-o"></i></li>
					</ul>
				</div>
			</div>
			<input type="button" value="提交修改" id="submitmess" style="position: absolute ; top: 1120px;left: 45%">
			<form action="/objectdesign/CreateMyCardServlet">
				<input type="submit" value="生成我的名片" id="createCard" style="position: absolute ; top: 1120px;left: 50%">
			</form>
		</div>
		<iframe src="buttom.html" width="100%" height="200px" scrolling="no" frameborder="0" style="position: absolute; left: 0;top:1200px;"></iframe>
	</body>
	<script type="text/javascript">
		$('#submitmess').on("click",function () {
			var user1_workid = document.getElementById('worker_id').innerHTML;
			var user1_name = document.getElementById('worker_name').innerHTML;
			var user1_sex = document.getElementById('worker_sex').innerHTML;
			var user1_age = document.getElementById('worker_age').innerHTML;
			var user1_sessid = document.getElementById('worker_section').innerHTML;
			var user1_position = document.getElementById('worker_position').innerHTML;
			var user1_site = document.getElementById('worker_site').innerHTML;
			$.ajax({
				data:"user1_workid="+user1_workid+"&user1_name="+user1_name+"&user1_sex="+user1_sex+
						"&user1_age="+user1_age+"&user1_sessid="+user1_sessid+"&user1_position="+user1_position+"&user1_site="+user1_site,
				type : 'post',
				url :'${pageContext.request.contextPath}/ChangeMyMessageServlet',
				success: function (data) {
					alert(data);
				}
			})
		})
	</script>
</html>
