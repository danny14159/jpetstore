<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="IncludeTop.jsp"%>
<script language="javascript">
var secs = 3; //倒计时的秒数 
var URL ;
function Load(url){
URL = url;
for(var i=secs;i>=0;i--) 
{ 
   window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000); 
} 
}
function doUpdate(num) 
{ 
document.getElementById('ShowDiv').innerHTML = '您搜索的宠物找不到了<br/>将在'+num+'秒后自动跳转到主页' ;
if(num == 0) { window.location = URL; }
}
</script>
<style>
#ShowDiv{margin-top:90px;margin-left:500px;float:left;text-decoration: center;}
.pic{float:right;margin-right:90px;}
</style>
<body onload="Load('index.jsp')">  
<center>
<div id="ShowDiv"><br/></div> 
<div class="pic"><img src="../images/cuo.jpg"/></div>
</center>
</body>
<%@ include file="IncludeBottom.jsp"%>
