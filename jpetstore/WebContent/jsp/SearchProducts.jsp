<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="IncludeTop.jsp"%>
<style>
.left-menu {
	margin-left: 2em;
}
.tb-main{float: none!important;width:70%;margin: 0 auto;}
.table{width:100%}
</style>

<div class="left-menu">
	<a href="<c:url value="/shop/index.do"/>">&lt;&lt; 返回</a>
</div>
<center>
<c:if test="${keyEmpty == true}">
<img style="width:700px;height:400px;" src="../images/kong2.jpg"/>
</c:if>
<c:if test="${pager.recordCount == 0}">
	<img style="width:700px;height:400px;" src="../images/kong1.jpg"/>
</c:if>
</center>
<c:if test="${keyEmpty == false and pager.recordCount!=0}">
<center><div id="pager"></div><div style="font-size: 14px;color:#999">共${pager.recordCount}条记录，每页${pager.pageSize}条</div></center>
<div class="col-md-8 tb-main" style="width: 450px">
	<table class="table table-striped">
		<tr>
			<td >
				&nbsp;
			</td>
			<td width="100px">
				Product ID
			</td>
			<td width="100px">
				Name
			</td>
		</tr>
		<c:forEach var="product" items="${pager.list}">
			<tr>
				<td width="180px">
					<a
						href="<c:url value="/shop/viewItem.do"><c:param name="productId" value="${product.productid}"/></c:url>">
						<c:out value="${product.descn}" escapeXml="false" />
					</a>
				</td>
				<td width="100px">
					<a
						href="<c:url value="/shop/viewItem.do"><c:param name="productId" value="${product.productid}"/></c:url>">
						<c:out value="${product.productid}" /> </a>
				</td>
				<td width="50px">
					<c:out value="${product.name}" />
				</td>
			</tr>
		</c:forEach>

	</table>
</div>
</c:if>

<script src="../static/js/laypage.js"></script>
<script>
laypage({
    cont: 'pager',
    pages: ${pager.pageCount }, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
    curr: ${pager.pageNumber }, //通过url获取当前页，也可以同上（pages）方式获取 
    jump: function(e, first){ //触发分页后的回调
        if(!first){ //一定要加此判断，否则初始时会无限刷新
            location.href = '?key=${param.key}&ps=4&pn='+e.curr;
        }
    },
    skin: '#AF0000',
});
</script>
<%@ include file="IncludeBottom.jsp"%>
