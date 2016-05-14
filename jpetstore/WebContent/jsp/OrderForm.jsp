<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="IncludeTop.jsp"%>

<form action="" method="post">

<table class="table table-striped" style="width:50%;margin: 0 auto;margin-bottom: 30px;">
<tbody><tr><td colspan="2">
<p class="bg-success">Payment Details</p>

</td></tr><tr><td>
Card Type:</td><td>
  
    <select name="cardtype">
      
        <option selected="" value="Visa">
        Visa</option>
	    
        <option value="MasterCard">
        MasterCard</option>
	    
        <option value="American Express">
        American Express</option>
	    
    </select>
  
</td></tr>
<tr><td>
Card Number:</td><td>
  
	  <input type="text" name="creditcard" value="999 9999 9999 9999">
  
</td></tr>
<tr><td>
Expiry Date (MM/YYYY):</td><td>
  
	  <input type="text" name="exprdate" value="12/03">
  
</td></tr>
<tr><td colspan="2">
<p class="bg-success">Billing Address</p>
</td></tr>

<tr><td>
First name:</td><td>
  
	  <input type="text" name="billtofirstname" value="${account.firstname }">
  
</td></tr>
<tr><td>
Last name:</td><td>
  
	  <input type="text" name="billtolastname" value="${account.lastname }">
  
</td></tr>
<tr><td>
Address 1:</td><td>
  
	  <input type="text" size="40" name="billaddr1" value="${account.addr1 }">
  
</td></tr>
<tr><td>
Address 2:</td><td>
  
	  <input type="text" size="40" name="billaddr2" value="${account.addr2 }">
  
</td></tr>
<tr><td>
City: </td><td>
  
	  <input type="text" name="billcity" value="${account.city }">
  
</td></tr>
<tr><td>
State:</td><td>
  
	  <input type="text" size="4" name="billstate" value="${account.city }">
  
</td></tr>
<tr><td>
Zip:</td><td>
  
	  <input type="text" size="10" name="billzip" value="${account.zip }">
  
</td></tr>
<tr><td>
Country:</td><td>
  
  	<input type="hidden" name="op" value="submitOrder"/>
	  <input type="text" size="15" name="billcountry" value="${account.country }">
  
</td></tr>

<tr><td colspan="2">
  
    <button type="submit" class="btn btn-danger">提交</button>
  
</td></tr>

</tbody></table>

</form>
<%@include file="IncludeBottom.jsp"%>