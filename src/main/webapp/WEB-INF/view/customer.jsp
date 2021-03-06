<%--
  Created by IntelliJ IDEA.
  User: bfy
  Date: 17-11-3
  Time: 下午12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>客户管理界面</title>
</head>
<body>

<h1>客户理表</h1>

<table>
    <th>客户名称</th>
    <th>联系人</th>
    <th>电话号码</th>
    <th>邮箱地址</th>
    <th>操作</th>
    <c:forEach var="Customer" items="${customerList}">
        <tr>
            <td>${Customer.name} </td>
            <td>${Customer.contact} </td>
            <td>${Customer.telephone} </td>
            <td>${Customer.email} </td>
            <td>
                <a href="${BASE}/customer_edit?id=${Customer.id}">编辑</a>
                <a href="${BASE}/customer_delete?id=${Customer.id}">删除</a>
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
