<%@ page import="bean.Message" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/Chat.css"/>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        window.onload = function() {
               alert('hi');
               var Words = document.getElementById("words");
               var TalkSub = document.getElementById("talksub");
               var message = document.getElementById("talkwords");
               $.ajax({
                   date:"message="+message,
                   data_type : 'text',
                   type : 'get',
                   url :'${pageContext.request.contextPath}/MyChatServlet',
                   success:function (data) {
                       TalkSub.onclick = function() {
                           //定义空字符串
                           if(TalkWords.value == "") {
                               // 消息为空时弹窗
                               alert("消息不能为空");
                               return;
                           }
                           var str = '<div class="atalk"><span>你说 :' + data + '</span></div>';
                           Words.innerHTML = Words.innerHTML + str;
                       }
                   }
               })
        }
    }
    </script>
</head>

<body>
<div class="talk_con">
    <div class="talk_show" id="words">
        <div class="atalk"><span id="asay">A说：吃饭了吗？</span></div>
        <div class="btalk"><span id="bsay">B说：还没呢，你呢？</span></div>
    </div>
    <div class="talk_input">
        <form action="">
            <input type="text" class="talk_word" id="talkwords" name="talkwords">
            <input type="button" value="发送" class="talk_sub" id="talksub">
        </form>
    </div>
</div>
</body>
</html>