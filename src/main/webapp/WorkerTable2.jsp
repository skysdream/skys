<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/ChangetText.js"></script>
    <style type="text/css">
        .contain{
            width:800px;
            height: 100%;
            position: absolute;
        }
        .contain td{
            width: 100px;
            height: 40px;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
       window.onload = function () {
           var tablebody = document.getElementById('tablebody');
           $.ajax({
               data:"tablebody="+tablebody,
               type : 'post',
               url :'MyWorkerServlet2',
               success: function (data) {
                   tablebody.innerHTML = tablebody.innerHTML + data;
                   //触发ajax事件
                   $('#addbtn').on("click",function () {
                       alert("ok");
                       var user1_workid = document.getElementById('Worker_Id').innerHTML;
                       var user1_name = document.getElementById('Worker_Name').innerHTML;
                       var user1_sex = document.getElementById('Worker_sex').innerHTML;
                       var user1_age = document.getElementById('Worker_Age').innerHTML;
                       var user1_sessid = document.getElementById('Session_Id').innerHTML;
                       var user1_position = document.getElementById('Worker_position').innerHTML;
                       var user1_site = document.getElementById('Worker_Site').innerHTML;
                       $.ajax({
                           data:"user1_workid="+user1_workid+"&user1_name="+user1_name+"&user1_sex="+user1_sex+
                               "&user1_age="+user1_age+"&user1_sessid="+user1_sessid+"&user1_position="+user1_position+"&user1_site="+user1_site,
                           type : 'post',
                           url :'${pageContext.request.contextPath}/ChangeWorkerMessageServlet',
                           success: function (data) {
                               alert(data);
                           }
                       })
                   })
               }
           });
       }
    </script>
</head>
<body>
<div class="contain">
    <table class="table" rules="all" bordercolor="black">
        <thead>
        <td>工号</td>
        <td>账号id</td>
        <td>姓名</td>
        <td>性别</td>
        <td>工龄</td>
        <td>部门</td>
        <td>职位</td>
        <td>地址</td>
        </thead>
        <tbody id="tablebody">

        </tbody>
    </table>
</div>
</body>
</html>