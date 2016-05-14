<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="IncludeTop.jsp"%>

<style>
table tr:hover{background: #345!important;cursor: pointer;color:#fff;}
</style>
<br/>
<center>我的订单</center>
    <table class="table" style="width:70%;margin: 0 auto;">
    <tr>
    <th>Order ID</th>
     <th>Date</th>
      <th>Total Price</th>
      <th></th>
    </tr>
     <c:forEach items="${listOrders}" var="order">
    <tr onclick="location.href='orderDetail.do?orderid=${order.orderid }'">
    <td>${order.orderid }</td>
    <td>${order.orderdate }</td>
    <td>${order.totalprice}</td>
    <td><a href="deleteorder.do?orderid=${order.orderid} " onClick="alert('确定删除吗？');" ><img src="../images/del.jpg" 
style="width: 20px; height: 20px" /></a></td>
    </tr>
    </c:forEach>
    </table>
<%@include file="IncludeBottom.jsp"%>