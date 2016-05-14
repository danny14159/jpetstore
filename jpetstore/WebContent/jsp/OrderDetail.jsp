<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="IncludeTop.jsp"%>

<style>
.table{width:50%;margin: 0 auto;display: block;}
</style>
<div>
	<a href="javascript:;" onclick="history.go(-1)" class="btn btn-default">返回&lt;&lt;</a>
</div>


<table class="table table-striped">
<tr><td align="center" colspan="2">
  <font size="4">Order #<c:out value="${order.orderid}"/></font>
  <br /><font size="3"><fmt:formatDate value="${order.orderdate}" pattern="yyyy/MM/dd hh:mm:ss" /></font>
</td></tr>
<tr><td colspan="2">
<font color="GREEN" size="4">Payment Details</font>
</td></tr>
<tr><td>
Card Type:</td><td>
<c:out value="${order.cardtype}"/>
</td></tr>
<tr><td>
Card Number:</td><td><c:out value="${order.creditcard}"/> <font color="red" size="2">* Fake number!</font>
</td></tr>
<tr><td>
Expiry Date (MM/YYYY):</td><td><c:out value="${order.exprdate}"/>
</td></tr>
<tr><td colspan="2">
<font color="GREEN" size="4">Billing Address</font>
</td></tr>
<tr><td>
First name:</td><td><c:out value="${order.billtofirstname}"/>
</td></tr>
<tr><td>
Last name:</td><td><c:out value="${order.billtolastname}"/>
</td></tr>
<tr><td>
Address 1:</td><td><c:out value="${order.billaddr1}"/>
</td></tr>
<tr><td>
Address 2:</td><td><c:out value="${order.billaddr2}"/>
</td></tr>
<tr><td>
City: </td><td><c:out value="${order.billcity}"/>
</td></tr>
<tr><td>
State:</td><td><c:out value="${order.billstate}"/>
</td></tr>
<tr><td>
Zip:</td><td><c:out value="${order.billzip}"/>
</td></tr>
<tr><td>
Country: </td><td><c:out value="${order.billcountry}"/>
</td></tr>
<tr><td colspan="2">
Shipping Address
</td></tr><tr><td>
First name:</td><td><c:out value="${order.shiptofirstname}"/>
</td></tr>
<tr><td>
Last name:</td><td><c:out value="${order.shiptolastname}"/>
</td></tr>
<tr><td>
Address 1:</td><td><c:out value="${order.shipaddr1}"/>
</td></tr>
<tr><td>
Address 2:</td><td><c:out value="${order.shipaddr2}"/>
</td></tr>
<tr><td>
City: </td><td><c:out value="${order.shipcity}"/>
</td></tr>
<tr><td>
State:</td><td><c:out value="${order.shipstate}"/>
</td></tr>
<tr><td>
Zip:</td><td><c:out value="${order.shipzip}"/>
</td></tr>
<tr><td>
Country: </td><td><c:out value="${order.shipcountry}"/>
</td></tr>
<tr><td>
Courier: </td><td><c:out value="${order.courier}"/>
</td></tr>
<tr><td colspan="2">
<table class="table table-striped">
  <tr>
  <td>Item ID</td>
  <td>Quantity</td>
  <td>Total Cost</td>
  </tr>
<c:forEach var="lineItem" items="${lineItem}">
  <tr>
  <td><a href="<c:url value="/shop/itemDetail.do"><c:param name="itemid" value="${lineItem.itemid}"/></c:url>">
    <c:out value="${lineItem.itemid}"/>
  </a></td>
  
  <td><c:out value="${lineItem.quantity}"/></td>
  <td align="right"><fmt:formatNumber value="${lineItem.unitprice}" pattern="$#,##0.00"/></td>
  </tr>
</c:forEach>
  <tr>
  <td colspan="5" align="right">Total: <fmt:formatNumber value="${order.totalprice}" pattern="$#,##0.00"/></td>
  </tr>
</table>
</td></tr>

</table>
<%@include file="IncludeBottom.jsp"%>