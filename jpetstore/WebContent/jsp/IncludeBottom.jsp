<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer">
		<ul class="footer_link">
			<li style="background: url('../static/img/add-to-cart.png') no-repeat;background-size:35px;padding-left: 35px; " class="addToCart">
			<a href="shoppingCart.do">购物车
			<c:if test="${cart!=null}">
			（${cart.numberOfItems}）
			</c:if>
			</a>|
			</li>
			<li><a href="index.do">Fly首页</a>|</li>
			<li>
				<c:if test="${account==null }">
					<a href="login.do">登录</a>|
					<a href="newAccount.do">注册</a>
				</c:if>
				<c:if test="${account!=null }">
					欢迎${account.firstname}，<a href="login.do?op=logout">退出登录</a>|
					<a href="listOrders.do">我的订单</a>|
					<a href="newAccount.do?op=modify">我的账户</a>
				</c:if>
			|</li>
			<li style="color: #868686;">All
				Rights Reserved</li>
		</ul>
</div>
</body>
</html>