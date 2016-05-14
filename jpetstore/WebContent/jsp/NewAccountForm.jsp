<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="IncludeTop.jsp"%>
<style>
#btn_submit{
	background-color: rgb(216, 55, 92);
	outline: none;
	border-radius: 3px;

	border:none;
	height: 80px;
	line-height: 40px;
	width: 100%;
	color:#fff;
	font-size:22px;
	font-weight:bold;
	width: 282px;
	margin-top:10px;
}
#btn_submit:hover{
	cursor:pointer;
	background-color: rgb(241, 98, 131);
}

.table1 tr:nth-child(odd){background: #FAF5F5;}
.table1 td,.table th{padding: 6px 6px 6px 12px;border: 1px solid #DAC1C1;;}
.table1 td{border: 1px solid #DAC1C1;}
.table1{font-size:19px}
}
.table1{font-family:'Trebuchet MS';border-radius:5%;}



</style>




<div style="height: 66px"></div>
<form action="account.do?op=${param.op}" method="post" onsubmit="return submitFrom();">
	<TABLE class="table11" style="width: 44%; margin: 0 auto;" >
		<TR>
			<TD>

				<div>

					<TABLE class="table1" style="width: 100%; margin: 0 auto;">
					<tr><td colspan="2" style="text-align:center" bgcolor="#EACACA">用户信息 &nbsp;&nbsp;&nbsp;</td></tr>
						<TR>
							<TD width=43%>
								&nbsp;User ID:
							</TD>
							<TD>
							<c:if test="${param.op=='modify'}">${account.userid}<input name="userid" type="hidden" required="required" value="${account.userid}"/></c:if>
							<c:if test="${param.op!='modify'}">	<input name="userid" type="text" required="required" value="${account.userid}"/></c:if>
							</TD>
						</TR>
						<TR>
							<TD>
								&nbsp;New password:
							</TD>
							<TD>
								<input name="password" type="password" required="required" value="${signon.password}"/>
							</TD>
						</TR>
						<TR>
							<TD>
								&nbsp;Repeat password:
							</TD>
							<TD>
								<input name="password2" type="password" required="required" value="${signon.password}"/>
							</TD>
						</TR>
				
<tr><td>&nbsp;FirstName:</td><td width=250px><input  name="firstname" type="text" required="required" value="${account.firstname }"/></td></tr>
<tr><td>&nbsp;LastName:</td><td ><input name="lastname" type="text" required="required" value="${account.lastname }"/></td></tr>
<tr><td>&nbsp;Email:</td><td><input name="email" type="text" required="required" value="${account.email }"/></td></tr>
<tr><td>&nbsp;Phone:</td><td><input  name="phone" type="text" required="required" value="${account.phone }"/></td></tr>
<tr><td>&nbsp;Address1:</td><td><input name="addr1" type="text" width="20px" required="required" value="${account.addr1 }"/></td></tr>
<tr><td>&nbsp;Address2:</td><td><input name="addr2" type="text"  value="${account.addr2 }"/></td></tr>
<tr><td>&nbsp;City:</td><td><input name="city" type="text" required="required" value="${account.city }"/></td></tr>
<tr><td>&nbsp;State:</td><td><input name="state" type="text" required="required" value="${account.state }"/></td></tr>
<tr><td>&nbsp;Zip:</td><td><input name="zip" type="text" required="required" value="${account.zip }"/></td></tr>
<tr><td>&nbsp;Country:</td><td><input name="country" type="text" required="required" value="${account.country }"/></td></tr>
						
<tr><td>&nbsp;Language Preference:</td><td><select name="langpref"> 
<option>English</option>
<option>Japanese</option>
</select></td></tr>
<tr><td>&nbsp;Favourite Category:</td><td><select name="favcategory"> 
<option>FISH</option>
<option>DOGS</option>
<option>REPTILES</option>
<option>CATS</option>
<option>BIRDS</option>
</select>
</td></tr>
<tr><td colspan="2"><input type="checkbox" name="checkbox1" 
<c:if test="${profile.mylistopt==1 }">
checked="checked"
</c:if>
/>  &nbsp;Enable MyList</td></tr>
<tr><td colspan="2">
<input type="checkbox" name="checkbox2" <c:if test="${profile.banneropt==1 }">
checked="checked"
</c:if> />  &nbsp;Enable MyBanner</td></tr>
</TABLE>

<div style="height: 33px"></div>
<div align="center">
<button class="btn btn-danger" id="btn_submit" 	>
<c:if test="${param.op=='modify'}">提交修改</c:if>
<c:if test="${param.op!='modify'}">立即注册</c:if>
</button></div>

				</div>
	</TABLE>

	<BR>
	<CENTER>
	
	</CENTER>

</form>

<script>
var op = '${param.op}';
$(function(){
	$('input').after($('<span class="msg">'));
	$('input').blur(function(){
		validNewAccount();
	});
	var language = '${profile.langpref}',favcategory = '${profile.favcategory}';
	if(language){
		$('select[name="langpref"]').val(language);
	}
	if(favcategory){
		$('select[name="favcategory"]').val(favcategory);
	}
})
function showWarning(input,msg){
	input.next('span.msg').html(msg).css({
		marginLeft:'2em',
		color:'red'
	});
}
function validNewAccount(){

	var userid = $('input[name=userid]');
	if(!userid.val()){
	 	showWarning(userid,"请输入用户名！");return false;
	}else{
		if(op!='modify')
			$.post('ajaxAccountExist.do',{
				userid:userid.val()
			},'json')
			.done(function(data){
				if(!data){
					showWarning(userid,"");
				}
				else{
					showWarning(userid,"该用户名已存在！");
				}
			});
		else showWarning(userid,"");
	}
	
	var password1 = $('input[name=password]');
	if(!password1.val()){
	 	showWarning(password1,"请输入密码！");return false;
	}else{
		showWarning(password1,"");
	}
	
	
	var password2 = $('input[name=password2]');
	if(password2.val() != password1.val()){
	 	showWarning(password2,"两次密码不相同！");return false;
	}else{
		showWarning(password2,"");
	}
	
	return true;
}
function submitFrom(){
	return validNewAccount() || false;
}
</script>
<%@ include file="IncludeBottom.jsp"%>