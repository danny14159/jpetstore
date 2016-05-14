<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
body{background: url('static/img/index.jpg') no-repeat;background-size:100%;}
button{background: #FFB0B0;border:none;width:50%;line-height: 2em;font-size: 4em;
border-radius:10px;color:#fff;display: block;opacity:0.5;left:100px;top:200px;position: absolute;}
</style>
  </head>
  
  <body>
  <script src="static/js/jquery-1.11.1.min.js"></script>
  <script src="static/js/jquery.easing.1.3.min.js"></script>
  <script>
  function fly(btn){
  		$(btn).animate({height:'100%',width:'100%',left:0,top:0,opacity:0.6},{duration: 500, 
	easing:"easeOutExpo",//可省略 
	complete: function(){
	  	
		  	location.href='shop/index.do'
	  }});
	  /*$(btn).fadeOut(500,function(){
	  	
		  	location.href='shop/index.do'
	  });*/
  }
  
  $(function(){
  	$('button').mouseover(function(){
  		$(this).stop(true,false).animate({'opacity':1})
  	}).mouseout(function(){
  		$(this).stop(true,false).animate({'opacity':0.5});
  	
  	})
  })
  </script>
   <button onclick="fly(this)">Enter Store</button>
  </body>
</html>

