 <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>&nbsp; 
 
<div id=no1>
<div style="text-align: center; width:50%;float:left;">
<table class="table" id=tableno01>
<tr><td colspan="2">Profile Information</td></tr>
<tr><td>FirstName:</td><td width=250px><input  name="FirstName" type="text" required="required" value="${account.firstname }"/></td></tr>
<tr><td>LastName:</td><td ><input name="LastName" type="text" required="required" value="${account.lastname }"/></td></tr>
<tr><td>Email</td><td><input name="Email" type="text" required="required" value="${account.email }"/></td></tr>
<tr><td>Phone</td><td><input  name="Phone" type="text" required="required" value="${account.phone }"/></td></tr>
<tr><td>Address1</td><td><input name="Address1" type="text" width="20px" required="required" value="${account.addr1 }"/></td></tr>
<tr><td>Address2</td><td><input name="Address2" type="text"  value="${account.addr2 }"/></td></tr>
<tr><td>City</td><td><input name="City" type="text" required="required" value="${account.city }"/></td></tr>
<tr><td>State</td><td><input name="State" type="text" required="required" value="${account.state }"/></td></tr>
<tr><td>Zip</td><td><input name="Zip" type="text" required="required" value="${account.zip }"/></td></tr>
<tr><td>Country</td><td><input name="Country" type="text" required="required" value="${account.country }"/></td></tr>

</table>
</div>
<div style="text-align: center; width:50%;float:left;">
<table style="border-bottom-width:4px;margin:0 auto;width:100%;float:left;" class="table">
<tr><td colspan="2">Profile Information</td></tr>
<tr><td>Language Preference:</td><td><select name="language"> 
<option>English</option>
<option>Japanese</option>
</select></td></tr>
<tr><td>Favourite Category:</td><td><select name="fav"> 
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
/>  Enable MyList</td></tr>
<tr><td colspan="2"><input type="checkbox" name="checkbox2"  checked="checked"/>  Enable MyBanner</td></tr>
</table>
<br/>
<div></div>
<button class="btn btn-danger" id="btn_submit" 	>
<c:if test="${param.op=='modify'}">提交修改</c:if>
<c:if test="${param.op!='modify'}">立即注册</c:if>
</button>
</div>
</div>
