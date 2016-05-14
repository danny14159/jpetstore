<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head><title>JPetStore Demo</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<META HTTP-EQUIV="Cache-Control" CONTENT="max-age=0">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<meta http-equiv="expires" content="0">
<META HTTP-EQUIV="Expires" CONTENT="Tue, 01 Jan 1980 1:00:00 GMT">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<!--<link href="../static/css/bootstrap.min.css" rel="stylesheet">
--><link href="../static/css/reset.css" rel="stylesheet">

<style>
@font-face{
	font-family: yuanxian; 
	src: url('../static/css/yuanxian.ttf'); 
}
body{
	font-family: 'Microsoft Yahei','宋体';
	padding-bottom: 49px;
	min-width: 960px;
	/*background: url('../static/img/bgbg.jpg') no-repeat;*/
	padding-top: 150px;
}
body,button,input{font-family: 'Microsoft Yahei'}
a{color:#BB0303;text-decoration: none;}

.nav{background: #333;background:-webkit-gradient(linear,center top,center bottom,from(#888), to(#333));
color:#fff;line-height: 3em;padding-left: 30%;position: absolute;width:70%;top:80px;z-index: 100}
.top-cat{display: block;padding-left: 50px;float: left}
.sub-cat{display: none;float: left;opacity:0.8}
.nav a:link,.nav a:visited{text-decoration: none;color:#fff;}
.sub-cat{background-color: #666;position: absolute;width: 100%;left:0;}
.sub-cat a{color:#fff;font-size: 0.8em;line-height: 1.3em;display: block;padding: 0.6em 0.4em;opacity:0.7}
.top-title{width:70px;opacity:0.7}
.clear{clear: both;}
.search-bar{width:440px;border:2px solid #C1C7D0;height: 2em;line-height: 2em;padding-left: 10px;position: absolute;left: 50%;top:20px;border-radius:4px}
.search-bar input{color:rgb(216, 55, 92);border: none;width: 360px;float: left;height: 32px;line-height: 32px;font-size: 16px;}
.search-bar input:FOCUS {outline: none;}
.search-bar button{float: left;background: rgb(216, 55, 92);border: none;color:#fff;height: 36px;line-height: 36px;width:80px;font-size: 1em;position: relative;top:-2px;right:-2px;border-radius:4px;}
.search-bar button:HOVER {cursor: pointer;background-color:rgb(173, 18, 53);}
button:FOCUS {outline: none;}
.search-bar.focus{border-color:rgb(199, 23, 64)!important;}
.search-bar.hover{border-color:rgb(216, 55, 92);}
.main-content{margin-top: 200px;}

.logo{background: url('../static/img/logo.jpg') no-repeat;width:354px;height: 100px;z-index: 1200;position: absolute;top:0px;left:50px;}
#header{
	height: 62px;
	border-bottom: 1px solid #9B2033;
	background: rgb(236, 85, 85); 
	font-family: 'yuanxian';
	position: relative;
}
#header h1{
	color:#fff;
	margin-left: 5%;
	font-size: 40px;
}
#header h1 span{position: relative;bottom: 10px;}
#header h1 img:hover{transform:scale(-1,1);cursor: pointer;}
#header input,#header button{position: absolute;right:1em;top:1em;font-family: '微软雅黑','宋体';}
#header input{width:200px;}
#footer{
	position: fixed;
	left:0;
	bottom: 0;
	color:#868686;
	border-top:3px solid rgb(216, 55, 92);
	clear:both;
	height:34px;
	width:100%;
	background-color:rgba(255,255,255,0.8);
	line-height: 34px;
	text-align: center;
	font-size: 12px;
}

#footer .footer_link li{
	display: inline-block;
	height: 34px;
	line-height: 34px;
}
#footer .footer_link a{
	padding: 0 4px;
	color: #BB0303;
	text-decoration: none;
	
}
.table img{width:180px;}
</style>
<script type="text/javascript" src="../static/js/jquery-1.11.1.min.js"></script>
<script>
jQuery.fn.extend({
	dropDown:function(callback){
		var _pos = this.css('position'),
			_top = this.css('top'); //css top
			height=this.height(),
			__top=this.offset().top, //
			self = this;
		this.css({
			position:'absolute',
			top:-1*height+__top,
			opacity:0
		}).show().animate({
			opacity:1,
			top:__top,
		},{
	duration: 1500, 
	easing:"easeOutBounce",
	callback:callback
	});
	}
});
//x,y单位是em，传入时不用写
function Sprite(x,y,ele){

	var self = this;
	this.ele = ele; //ele必须是jq对象
	
	this.MOVING_RANGE=0.1; //移动范围
	this.MIN_SPEED=400;//最小移动速度，单位ms
	this.MAX_SPEED=400;//最大移动速度，单位ms
	
	this.UNIT='em'; //单位
	
	this.x = x;
	
	this.y = y;
	this.stickTo=function(x,y){
		ele.css({
			top:y+this.UNIT,
			left:x+this.UNIT
		});
	};
	
	//移动
	this.moveTo=function(rx,ry,speed,callback){
		ele.animate({
			top:ry+this.UNIT,
			left:rx+this.UNIT
		},speed || this.DEFAULT_SPEED,'linear',callback);
	};
	
	//随机移动
	this.moveAround=function(range){
		range = range || self.MOVING_RANGE;
		console.log(range)
		var rspeed = Math.random()*(self.MAX_SPEED-self.MIN_SPEED)+self.MAX_SPEED;
		var rx =range*( Math.random()*2 -1 )+ self.x;
		var ry =range*( Math.random()*2 -1 )+ self.y;
		
		self.moveTo(rx, ry, rspeed,self.moveAround);
	}
	
	this.stickTo(this.x, this.y);
	
}
$(function(){
	//new Sprite(0,0,$('#header img:eq(0)')).moveAround();
	//new Sprite(0,0,$('#header img:eq(1)')).moveAround();
})
</script>
</head>

<body>
<a href="index.do">
<div class="logo"></div>
</a>

<div class="search-bar focus">
<form action="search.do?ps=4&pn=1" method="post">
	<input type="text" name="key" value="${param.key}"/>
	<button>搜索</button>
</form>
</div>

<div class="nav">
	<ul class="top-cat">
		<li>
		<div class="top-title"><a href="viewCategory.do?cate=CATS">萌猫</a></div>
		<ul class="sub-cat">
			<c:forEach items="${CATS}" var="item">
				
				<li><a href="viewItem.do?productId=${item.productid}">${item.name}</a></li>
			</c:forEach>
		</ul>
		</li>
	</ul>
	<ul class="top-cat">
		<li>
		<div class="top-title"><a href="viewCategory.do?cate=DOGS">爱狗</a></div>
		<ul class="sub-cat">
			<c:forEach items="${DOGS}" var="item">
				
				<li><a href="viewItem.do?productId=${item.productid}">${item.name}</a></li>
			</c:forEach>
		</ul>
		</li>
	</ul>
	<ul class="top-cat">
		<li>
		<div class="top-title"><a href="viewCategory.do?cate=FISH">鱼</a></div>
		<ul class="sub-cat">
			<c:forEach items="${FISH}" var="item">
				
				<li><a href="viewItem.do?productId=${item.productid}">${item.name}</a></li>
			</c:forEach>
		</ul>
		</li>
	</ul>
	<ul class="top-cat">
		<li>
		<div class="top-title"><a href="viewCategory.do?cate=REPTILES">蜥蜴</a></div>
		<ul class="sub-cat">
			<c:forEach items="${REPTILES}" var="item">
				
				<li><a href="viewItem.do?productId=${item.productid}">${item.name}</a></li>
			</c:forEach>
		</ul>
		</li>
	</ul>
	<ul class="top-cat">
		<li>
		<div class="top-title"><a href="viewCategory.do?cate=BIRDS">鹦鹉</a></div>
		<ul class="sub-cat">
			<c:forEach items="${BIRDS}" var="item">
				
				<li><a href="viewItem.do?productId=${item.productid}">${item.name}</a></li>
			</c:forEach>
		</ul>
		</li>
	</ul>
	<div class="clear"></div>
</div>

<script>
$(function(){
	//导航栏的hover事件
	$('.sub-cat li a').mouseover(function(){
		$(this).stop(true,false).animate({opacity:1},300);
	}).mouseleave(function(){
		$(this).stop(true,false).animate({opacity:0.7},300);
	});
	
	$('.top-cat>li').mouseover(function(){
		$(this).children('.top-title').stop(true,false).animate({opacity:1},300);
		$(this).children('.sub-cat').stop(true,false).slideDown(300);
	}).mouseleave(function(){
		$(this).children('.top-title').stop(true,false).animate({opacity:'0.7'},300);
		$(this).children('.sub-cat').stop(true,false).slideUp(300);
	});

	
	//搜索框的focus事件
/*	$('.search-bar input').focus(function(){
		$(this).parent().addClass("focus");
	}).blur(function(){
		$(this).parent().removeClass("focus");
	}).mouseover(function(){
		$(this).parent().addClass("hover");
	}).mouseleave(function(){
		$(this).parent().removeClass("hover");
	});*/
	
	//计算sub-cat的padding-left值
	$('.sub-cat li').each(function(){
		$(this).css('paddingLeft',$(this).parent().prev().position().left);
	});
	
	//\
	$('.search-bar input').focus(function(){
		$(this).val('');
	})
});

function renderCartNum(){
	
}
/**商品加入购物车，传入$goods_pic和$btn_cart即可实现添加动画
 * @param goods_no
 * @param goods_num
 * @param $goods_pic
 * @param $btn_cart
 */
function addToCart(goods_no,goods_num,$goods_pic,$btn_cart){
	//ajax添加
	$.post('ajax/shoppingCart.do',{
		itemid:goods_no,
		itemQty:goods_num,
		op:'addItem'
	},function(data){
		
		//购物车动画
		if($goods_pic && $btn_cart){
			
			var imgsprite = $goods_pic.clone();
			imgsprite.css({
				position:'absolute',
				left:$goods_pic.offset().left + 'px',
				top:$goods_pic.offset().top + 'px',
				width:$goods_pic.width()+'px',
				height:$goods_pic.height()+'px',
				'z-index':7000
			}).appendTo($('body')).animate({
				top:$btn_cart.offset().top+'px',
				left:$btn_cart.offset().left+'px',
				opacity:0,
				width:'0px',
				height:'0px',
			},500,function(){
				imgsprite.remove();
				
				//renderCartNum();
				location.reload();
			});
		}
	})
	
}

</script>
<!--<table>
  <tbody>
  <tr>
    <td><a href="<c:url value="/shop/index.do"/>"><img border="0" src="../images/logo-topbar.gif" /></a></td>
    <td align="right"><a href="<c:url value="/shop/viewCart.do"/>"><img border="0" name="img_cart" src="../images/cart.gif" /></a>
      <img border="0" src="../images/separator.gif" />

<c:if test="${empty userSession.account}" >
      <a href="<c:url value="/shop/signonForm.do"/>"><img border="0" name="img_signin" src="../images/sign-in.gif" /></a>
</c:if>

<c:if test="${!empty userSession.account}" >
      <a href="<c:url value="/shop/signoff.do"/>"><img border="0" name="img_signout" src="../images/sign-out.gif" /></a>
      <img border="0" src="../images/separator.gif" />
      <a href="<c:url value="/shop/editAccount.do"/>"><img border="0" name="img_myaccount" src="../images/my_account.gif" /></a>
</c:if>

      <img border="0" src="../images/separator.gif" /><a href="../help.html"><img border="0" name="img_help" src="../images/help.gif" /></a>
    </td>
    <td align="left" valign="bottom">
      <form action="<c:url value="/shop/searchProducts.do"/>" method="post">
			  <input type="hidden" name="search" value="true"/>
        <input name="keyword" size="14" />&nbsp;<input border="0" src="../images/search.gif" type="image"/>
      </form>
    </td>
  </tr>
  </tbody>
</table>


-->
