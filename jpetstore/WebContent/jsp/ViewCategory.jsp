<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="IncludeTop.jsp"%>
<style>
.table{width:70%;margin: 0 auto;display: block}
</style>
<div>
	<a href="index.do" class="btn btn-default">返回&lt;&lt;</a>
</div>


	<table class="table table-striped">
		<tr>
			<th>
				Product ID
			</th>
			<th>
				Name
			</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td><a href="viewItem.do?productId=${item.productid}">
				<c:out value="${item.productid}" />
				</a>
					
				</td>
				<td>
					<c:out value="${item.name}" />
				</td>
			</tr>
		</c:forEach>
	</table>

	<%@ include file="IncludeBottom.jsp"%>


<%@include file="IncludeBottom.jsp"%>