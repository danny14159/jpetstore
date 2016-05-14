<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<style>
#content{
	margin:0 auto;
	padding:0 32px;
}
#content .advert{
	height:372px;
	margin-left: 100px;
	margin-bottom: 60px;
	float: left;
	position: relative;
}
#content .login_wrapper{
	float:right;
	border:1px solid rgb(216, 55, 92);
	width: 334px;
	background-color: #fff;
	position: relative;
	padding: 0px;
	margin: 0 20px 0 0;
	border-radius: 5px;
	overflow: hidden;
	padding-bottom: 50px;
}
.login_wrapper .header{
	height:50px;
	border-bottom: 1px solid rgb(222, 175, 186);
	background-color: #f9fbfe;
	position: relative;
}
#content .loginTips{
	height: 28px;
	padding-top: 4px;
	width:282px;
	line-height: 28px;
	font-size: 12px;
	color:red;
}
#content .header{
	color:#333;
	display: inline-block;
	height: 45px;
	line-height: 45px;
	width:100%;
	padding-left: 15px;
}
#content .header>span{
	color: rgb(216, 55, 92);
}
#content .inputOuter{
	border: 1px solid #ccc;
	height: 38px;
	width: 282px;
	border-radius: 2px;
	margin:10px auto;
	margin-top: 0;
}
#content .inputOuter>input{
	top: 0px;
	padding:0;
	padding-left:15px;
	left: 0px;
	border-radius: 3px;
	width: 100%;
	position: relative;
	height: 38px;
	line-height: 18px;
	border: 0;
	background: 0;
	color: #333;
	font-size: 16px;
}
#content .inputOuter>input:focus{
	background:#fffaf3; 
	border:1px solid #F90; 
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.15);
}
#btn_submit{
	background-color: rgb(216, 55, 92);
	outline: none;
	border-radius: 3px;
	
	border:none;
	height: 40px;
	line-height: 40px;
	width: 100%;
	
	color:#fff;
	font-size:16px;
	font-weight:bold;
	width: 282px;
	margin-top:10px;
}
#btn_submit:hover{
	cursor:pointer;
	background-color: rgb(241, 98, 131);
}
#content .form_wrapper{
	width:282px;
	margin:0 auto;
}
#content .bottom{
	margin-bottom: 12px;
	width: 282px;
	bottom: 2px;
	font-size: 12px;
	text-align: right;
	color: #bfbfbf;
	position: absolute;
}
#content .bottom a{
	color: #225592;
	text-decoration: none;
}
#content .bottom a:hover{
	text-decoration: underline;
}

#content .entry_wrapper{
	margin-bottom: 36px;
}
#content .entry_wrapper>h2{
	color: rgb(111, 149, 200);
	color:#00808C;
	font-size:24px;
}
#content .entry_wrapper>span{
	color:#999;
	font-size:14px;
	margin-left: 2em;
}
#content .advert>a{
	color:#225592;
	font-size: 12px;
	display: block;
	
	margin-left: 450px;
}
#content .bottom>a[rel="forget"]{
	color:red;
}
.checkcode:hover{cursor: pointer;}
.checkcode{display: block;padding-left: 15px;width:150px}
</style>

<%@ include file="IncludeTop.jsp" %>
<div id="content">
	<div class="advert">
		<img src="../static/img/signon.png" width="300px"/>
		<!--<div class="entry_wrapper">
			<h2>便捷管理</h2>
			<span>抛弃复杂繁琐，难以管理的excel,word表格，成绩管理，易如反掌</span>
		</div>
		<div class="entry_wrapper">
			<h2>精准分析</h2>
			<span>让您在第一时间内掌握学生最准确的学习情况</span>
		</div>
		<div class="entry_wrapper">
			<h2>随时随地</h2>
			<span>电脑、平板、甚至在智能手机上都可以随时随地查看最新成绩</span>
		</div>
		<a href="#">了解更多...</a>
		
	--></div>
	<div class="login_wrapper">
		<div class="header">
			登录<span> Fly宠物商店</span>
		</div>
		
		<div class="form_wrapper">
				<div class="loginTips">${msg}</div>
				
				<form action="" method="post">
				<div class="inputOuter" >
					<input type="text" placeholder="用户名" name="username" value="${param.username}"/>
				</div>
				
				<div class="inputOuter">
					<input type="password" placeholder="密码" name="password" value="${param.password}"/>
				</div><!-- 
				 --><div class="inputOuter" style="width: 40%;display:block;float: left;">
					<input type="text" placeholder="验证码" name="checkcode"	/>
				</div>
				<img src="checkcode.do" onclick="this.src='checkcode.do?_nocache='+new Date().valueOf();" class="checkcode" title="更换验证码"/>
				
				<button id="btn_submit" type="button">登 录</button>
				</form>
				<div class="bottom">
					<a href="newAccount.do" rel="forget">现在注册</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
				</div> 
		</div>
	</div>
</div>

<script type="text/javascript" src="../static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">

//解决IE不支持placeholder的问题
(function ($) {
    $.fn.placeholder = function (options) {
        var defaults = {
            pColor: "#ccc",
            pActive: "#999",
            pFont: "14px",
            activeBorder: "#080",
            posL: 8,
            zIndex: "99"
        },
        opts = $.extend(defaults, options);
        //
        return this.each(function () {
            if ("placeholder" in document.createElement("input")) return;
            $(this).parent().css("position", "relative");
            var isIE = /msie/.test(navigator.userAgent.toLowerCase()),
            version = navigator.userAgent.toLowerCase() .match(/msie [0-9].0/).toString().match(/[0-9]/).toString();
  
            //不支持placeholder的浏览器
            var $this = $(this),
                msg = $this.attr("placeholder"),
                iH = $this.outerHeight(),
                iW = $this.outerWidth(),
                iX = $this.position().left,
                iY = $this.position().top,
                oInput = $("<label>", {
                "class": "test",
                "text": msg,
                "css": {
                    "position": "absolute",
                    "left": iX + "px",
                    "top": iY + "px",
                    "width": iW - opts.posL + "px",
                    "padding-left": opts.posL + "px",
                    "height": iH + "px",
                    "line-height": iH + "px",
                    "color": opts.pColor,
                    "font-size": opts.pFont,
                    "z-index": opts.zIndex,
                    "cursor": "text"
                }
                }).insertBefore($this);
            //初始状态就有内容
            var value = $this.val();
            if (value.length > 0) {
            oInput.hide();
            };
  
            //
            $this.on("focus", function () {
                var value = $(this).val();
                if (value.length > 0) {
                    oInput.hide();
                }
                oInput.css("color", opts.pActive);
                //
  
                if(isIE && version < 9){
                    var myEvent = "propertychange";
                }else{
                    var myEvent = "input";
                }
  
                $(this).on(myEvent, function () {
                    var value = $(this).val();
                    if (value.length == 0) {
                        oInput.show();
                    } else {
                        oInput.hide();
                    }
                });
  
            }).on("blur", function () {
                var value = $(this).val();
                if (value.length == 0) {
                    oInput.css("color", opts.pColor).show();
                }
            });
            //
            oInput.on("click", function () {
                $this.trigger("focus");
                $(this).css("color", opts.pActive)
            });
            //
            $this.filter(":focus").trigger("focus");
        });
    };
})(jQuery);


var showTip=function(msg){
	$('#content div.loginTips').html(msg);
}
$(function(){
	//按钮绑定事件
	$('#btn_submit').click(function(){
		var username=$('input[name="username"]').val();
		var password=$('input[name="password"]').val();
		if(!username){
			showTip('您还没有输入帐号！')
			return;
		}
		if(!password){
			showTip('您还没有输入密码！');
			return;
		}
		
		$(this).closest('form').submit();

	});
	
	$('#username').focus(function(){
		showTip('');
	});
	$('#password').focus(function(){
		showTip('');
	});
	
	$(document).keyup(function(event){
		if(event.which == 13){
			$('#btn_submit').click();
		}
	});
	
	if(navigator.userAgent.toLowerCase().match(/msie/) != null ){
		
		$(":input[placeholder]").each(function(){
			$(this).placeholder();
		});
	}
});
</script>
<%@include file="IncludeBottom.jsp"%>

