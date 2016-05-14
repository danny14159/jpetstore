<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="IncludeTop.jsp"%>
<style>

#mainimage{position: absolute;left:45%;top:140px;opacity:0;}
#sidebar{position: absolute;left:3em;top:6em;opacity:0;border: 1px solid #ccc; }
#sidebar li{margin: 1em 0;       
    border-bottom: 1px solid #eee;}
#sidebar li:hover{background-color: #eee;}
#sidebar li a{width:100%;display: block;padding: 10px 20px;}
#postBar {
	background-color:#EACACA;
    width:100%;
    position:absolute;
    bottom:50px;
    
}
.rotations{width:100%;position: relative;}/*n*100% 需要指定图片的宽高*/
.rotations li{float:left;display:block;}
.rotations li:hover{cursor: pointer;}
.wrapper{overflow: hidden;width:600px;margin: 0 auto;}

.btm_nav{margin-top: 5px;}
.btm_nav{width:100%}
.btm_nav li{width:25%;height: 3em;line-height: 3em;text-align: center;float: left;background: #e9eaea;color:#969494;border-bottom: 5px solid #ccc;}
.btm_nav li.active{background: rgb(216, 55, 92)!important;color:#fff!important;border-bottom: 5px solid rgb(173, 18, 53);}
.btm_nav li.active span{opacity:1!important;}
.btm_nav li:hover{background: #b3b6bb;color:#fff;cursor: pointer;}
</style>
<div class="wrapper">
<ul class="rotations">
</ul>
<ul class="btm_nav">
	<!--<li class="active">CATS</li>
	<li>CATS</li>
	<li>CATS</li>
	<li>CATS</li>
--></ul>
</div>

<script src="../static/js/jquery.easing.1.3.min.js"></script>
<script>
function enter() {
	$('#sidebar').dropDown();
		$('#mainimage').dropDown();
	
}
$(function(){

new RotateImages($('.rotations'),imgSrc);
})
//首页轮播图片数据
var imgSrc=[
            {src:'../static/img/banner/dcat.jpg',link:'viewCategory.do?cate=CATS',title:'猫咪的陪伴'},
            {src:'../static/img/banner/dog.jpg',link:'viewCategory.do?cate=DOGS',title:'萌萌的汪星人'},
            {src:'../static/img/banner/bird.jpg',link:'viewCategory.do?cate=BIRDS',title:'鹦鹉之声'},
            {src:'../static/img/banner/lizard.jpg',link:'viewCategory.do?cate=REPTILES',title:'蜥小蜴'},
            {src:'../static/img/banner/fish.jpg',link:'viewCategory.do?cate=FISH',title:'鱼宝宝'},
            ];

//getRegion();
function RotateImages($target,imgSrc){
	var self = this,len = imgSrc.length;
	this.width = null;
	this.height = null;
	
	function showDestImage(index){
		$target.animate({
			left:index*self.width*-1 
		},{
			duration: 800, 
			easing:"easeOutQuint",
			complete:function(){}
		});
		$('.btm_nav li').each(function(i,v){
			v = $(v);
			if(i==index){
				v.stop(true,false).animate({'opacity':1}).addClass('active');
			}
			else{
			 v.stop(true,false).animate({'opacity':0.8}).removeClass('active');
			 }
		});
	}
	
	//预加载图片数据，宽，高
	var imgFirst = new Image();
	imgFirst.onload = function(){
		self.width = '600';
		self.height = imgFirst.height/imgFirst.width * self.width;
		
		var t = $target;
		t.css({
			width:self.width*len,
			height:self.height
		});
		$.each(imgSrc,function(i,v){
			$('<li>').append($("<img width='600px'>").attr('src',v.src)).appendTo(t).click(function(){
				location.href=(v.link);
			}).css({
				width:self.width,
				height:self.height
			});
			$('<li>').css({width:100/imgSrc.length + '%'}).html('<span>'+v['title']+'</span>').appendTo(t.next('.btm_nav'))
			.click(function(){
				//location.href=v.link;
			});
		});
		$('.btm_nav').children('li').click(function(){
			_rotIndex = $(this).index();
			clearInterval(th_rot);
			startRot();
		});
		
		var _rotIndex = 0;
		function startRot(){
			showDestImage(_rotIndex);
			th_rot = setInterval(function(){
				showDestImage((++_rotIndex)%len);
			},2800);
		}
		startRot();
	}
	imgFirst.src=imgSrc[0]['src'];
	
}
</script>

<%@include file="IncludeBottom.jsp"%>
