<%--
  Created by IntelliJ IDEA.
  User: awen
  Date: 2020/12/30
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%--当前页面获取应用上下文，项目名称--%>
<c:set value="${pageContext.request.contextPath}" var="appPath"/>
<%--<c:out value="${appPath}"/>--%>