<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="IncludeTop.jsp"%>

<style>
.table {
	width: 70%;
	margin: 0 auto;
	display: block
}
</style>
<div>
	<a onclick="history.go(-1);" href="javascript:;"
		class="btn btn-default">返回&lt;&lt;</a>
</div>

<table class="table table-striped">
	<tr>
		<td>
			<c:out value="${product.descn}" escapeXml="false" />
		</td>
	</tr>
	<tr>
		<td>
			<c:out value="${item.itemid}" />
		</td>
	</tr>
	<tr>
		<td>
			<c:out value="${item.attr1}" />
			<c:out value="${item.attr2}" />
			<c:out value="${item.attr3}" />
			<c:out value="${item.attr4}" />
			<c:out value="${item.attr5}" />
			<c:out value="${product.name}" />
		</td>
	</tr>
	<tr>
		<td>
			<i><c:out value="${product.name}" />
			</i>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${inventory.qty <= 0}">
				<font color="RED" size="2"><i>Back ordered.</i>
				</font>
			</c:if>
			<c:if test="${inventory.qty > 0}">
				<font size="2"><fmt:formatNumber value="${inventory.qty}" />
					in stock.</font>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<fmt:formatNumber value="${item.listprice}" pattern="$#,##0.00" />
		</td>
	</tr>

	<tr>
		<td>
			<a  class="btn btn-danger" href="<c:url value="/shop/shoppingCart.do">
			<c:param name="itemid" value="${item.itemid}"/>
			<c:param name="op" value="addItem"/>
			<c:param name="itemQty" value="1"/>
			</c:url>
			">
				 加入购物车</a>
		</td>
	</tr>
</table>
<%@include file="IncludeBottom.jsp"%>