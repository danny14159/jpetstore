<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="IncludeTop.jsp"%>

<style>
.content{width:90%;margin: 0 auto;display: block;text-align: center;}
.icon-cart{font-style: normal;background: url('../static/img/add-to-cart.png') no-repeat;
display: block;width:100%;height: 59px;text-align: center;line-height: 59px;background-position-x:22px;padding-left: 22px; }
.item-grid{width:180px;height: 270px;display: inline-block;border: 1px solid #EDEDED;
	margin-right: 15px;position: relative;margin-bottom: 15px;font-size: 12px;}
.cart{position: absolute;top: 121;width:179px;display: block;background: rgb(216, 55, 92);z-index: 1;height: 2em;line-height: 2em;color:#FFF}
.item-grid img{width:180px;height: 180px;text-align: left;}
.item-grid:hover{cursor: pointer;}
.item-id{text-align: right;margin-left: 50px;}
.price{font-size: 18px;text-align: left;margin-left: 12px;font-weight: bold;color:rgb(216, 55, 92)}
.cart span{}
.product-id{text-align: left;margin-left: 12px;}
.descn{text-align: left;line-height: 1.5em;color:#999;margin-left: 12px;}
.border{width:178px;height: 268px;background:rgb(216, 55, 92);position: absolute;display: none;}

.border.left{width:1px;height: 270px;left:0;top:0}
.border.right{width:1px;height: 270px;right:0;top:0}
.border.top{width:180px;height: 1px;top:0;left:0;}
.border.bottom{width:180px;height: 1px;bottom:0;left:0;}
.grid-mask{position: absolute;width:174px;left:5px;z-index: 2;background: #fff;bottom: 1px;}
</style>
<div>
	<a onclick="history.go(-1);" href="javascript:;" class="btn btn-default">返回&lt;&lt;</a>

	
</div>


<div class="content">
<c:forEach var="item" items="${list}">
	<div class="item-grid" onclick="location.href='<c:url value="/shop/itemDetail.do"><c:param name="itemid" value="${item.itemid}"/></c:url>'">
		${product.descn}
		
		<div class="grid-mask">
			<p style="text-align: left;">
				<span class="price"><fmt:formatNumber value="${item.listprice}" pattern="$#,##0.00" /></span>
				<span class="item-id">
					<a href="<c:url value="/shop/itemDetail.do"><c:param name="itemid" value="${item.itemid}"/></c:url>">
								<c:out value="${item.itemid}" /> </a>
				</span>
			</p>
			<div class="product-id">${item.product.productid}</div>
			<div class="descn">
					<c:out value="${item.attr1}" />
					
			</div>
		</div>
		<a class="cart" href="javascript:;" onclick="event.stopPropagation();addToCart('${item.itemid}',1,$(this).closest('.item-grid').find('img'),$('.addToCart'))">加入购物车
		<span><span/>
		</a>
		<div class="border top"></div>
		<div class="border left"></div>
		<div class="border bottom"></div>
		<div class="border right"></div>
		
	</div>
</c:forEach>
</div>
	<table class="table table-striped" style="display: none;">
		<tr>
			<th>
				Item ID
			</th>
			<th>
				Product ID
			</th>
			<th>
				Description
			</th>
			<th>
				List Price
			</th>
			<th>
				操作
			</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>
					<a
						href="<c:url value="/shop/itemDetail.do"><c:param name="itemid" value="${item.itemid}"/></c:url>">
						<c:out value="${item.itemid}" /> </a>
				</td>
				<td>
					<c:out value="${item.product.productid}" />
				</td>
				<td>
					<c:out value="${item.attr1}" />
					<c:out value="${item.attr2}" />
					<c:out value="${item.attr3}" />
					<c:out value="${item.attr4}" />
					<c:out value="${item.attr5}" />
					<!--<c:out value="${product.name}" />
				--></td>
				<td>
					<fmt:formatNumber value="${item.listprice}" pattern="$#,##0.00" />
				</td>
				<td>
<a  class="btn btn-danger" href="<c:url value="/shop/shoppingCart.do">
			<c:param name="itemid" value="${item.itemid}"/>
			<c:param name="op" value="addItem"/>
			<c:param name="itemQty" value="1"/>
			</c:url>
			">
				 加入购物车</a>				</td>
			</tr>
		</c:forEach>
	</table>
<script>
$(function(){
	$('.cart').each(function(){
		$(this).css({top:$(this).prev('.grid-mask').position().top});
	})
	$('.item-grid').mouseover(function(){
		$(this).find('.border').stop(true,false).fadeIn(100);
		$(this).find('.cart').stop(true,false)
		//.css({top:$(this).find('.grid-mask').position().top})
		.animate({
			top:180-$(this).find('.cart').height()
		},100)
	}).mouseout(function(){
		$(this).find('.border').stop(true,false).fadeOut(200);
		//alert($(this).find('.grid-mask').position().top)
		$(this).find('.cart').stop(true,false).animate({
			top:$(this).find('.grid-mask').position().top
		},100)
	})
})
</script>
	<%@ include file="IncludeBottom.jsp"%>
