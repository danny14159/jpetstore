
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="IncludeTop.jsp"%>
<link rel="stylesheet" href="../static/css/style.css" type="text/css" media="screen" charset="utf-8">

	<script src="../static/js/jquery-1.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../static/js/slider.js" type="text/javascript" charset="utf-8"></script>
<style>
.ta{background-color:white;}
.table{margin: 0 auto;display: block;}
h2{margin: 0 auto;width:100px;margin-bottom: 20px;}
.recommend{position: absolute;left:1em;top:10em;width:202px;border:1px solid rgb(183, 45, 45);border-bottom-width: 4px;}
.recommend h3{background: rgb(183, 45, 45);font-size: 1em;line-height: 2em;height:2em;text-align: center;color:#fff;}
</style>
<div>
	<a href="../shop/index.do" class="btn btn-default">返回&lt;&lt;</a>
</div>

<c:if test="${cart.numberOfItems  == 0}">
<center><img style="margin-left:100px;margin-top:90px;;width:600px;height:300px" src="../images/shcart.jpg" /></center>
</c:if>
<c:if test="${cart.numberOfItems >0}">
<h2 align="center">购物车</h2>
<form action="<c:url value="/shop/updateCartQuantities.do"/>" method="post">
<table class="table table-striped" style="text-align: center">
  <tr>
  <th>Item ID</th>  <th>Product ID</th>  <th>Description</th> <th>In Stock?</th> <th>Quantity</th>  <th>List Price</th> <th>Total Cost</th>  <th>&nbsp;</th>
  </tr>

<c:forEach var="cartItem" items="${cart.cartItemList}">
  <tr>
  <td>
  <a href="<c:url value="/shop/itemDetail.do"><c:param name="itemid" value="${cartItem.item.itemid}"/></c:url>">
    <c:out value="${cartItem.item.itemid}"/>
  </a></td>
  <td><c:out value="${cartItem.item.product.productid}"/></td>
  <td>
    <c:out value="${cartItem.item.attr1}"/>
    <c:out value="${cartItem.item.attr2}"/>
    <c:out value="${cartItem.item.attr3}"/>
    <c:out value="${cartItem.item.attr4}"/>
    <c:out value="${cartItem.item.attr5}"/>
    <c:out value="${cartItem.product.name}"/>
   </td>
  <td ><c:out value="${cartItem.inStock}"/></td>
  <td style="width: 130px">
  <a class="btn btn-xs btn-default" href="shoppingCart.do?itemid=${cartItem.item.itemid}&op=addItem&itemQty=-1">-</a>
  <c:out value="${cartItem.quantity}"/>
  <a class="btn btn-xs btn-default" href="shoppingCart.do?itemid=${cartItem.item.itemid}&op=addItem&itemQty=1">+</a>
  </td>
  <td><fmt:formatNumber value="${cartItem.item.listprice}" pattern="$#,##0.00" /></td>
  <td><fmt:formatNumber value="${cartItem.totalPrice}" pattern="$#,##0.00" /></td>
  <td>
  <a class="btn btn-default" href="<c:url value="/shop/shoppingCart.do">
  <c:param name="itemid" value="${cartItem.item.itemid}"/>
  <c:param name="op" value="removeItem"/>
  </c:url>">
  移除
  </a></td>
  </tr>
</c:forEach>
<tr>
<td colspan="7">
总价<fmt:formatNumber value="${cart.subTotal}" pattern="$#,##0.00" />

</td>
<td><a class="btn btn-primary" href="<c:url value="/shop/newOrder.do"/>">提交订单</a></td>
</tr>
</table>
</form>



</c:if>

<c:if test="${account!=null}">

<div id="wrapper">
<h1>为您推荐</h1>

        <div id="slider">    

            <img style="width:30px;height:38px" class="scrollButtons left" src="../images/leftarrow.png">

			<div style="overflow: hidden;" class="scroll">
	
				<div class="scrollContainer">
	<c:forEach var="p" items="${pd}" varStatus="status">
	
	                 <div class="panel" id="panel_${status.index }">
						<div style="float:left;" class="inside">
						    <a href="viewItem.do?productId=${p.productid }">${p.descn }</a>
							<a href="viewItem.do?productId=${p.productid }">${p.productid }</a>
						</div>
					</div>
					</c:forEach>
                </div>

				<div id="left-shadow"></div>
				<div id="right-shadow"></div>

            </div>

			<img style="width:30px;height:38px" class="scrollButtons right" src="../images/rightarrow.png">

        </div>
        
    </div>
</c:if>

<%@include file="IncludeBottom.jsp"%>