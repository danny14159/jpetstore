<%@ include file="IncludeTop.jsp" %>

<% String getLangpref = request.getParameter("getLangpref"); %>
<% String getFavcategory = request.getParameter("getLangpref"); %>
<% String isMylistopt = request.getParameter("isMylistopt"); %>
<% String isBanneropt = request.getParameter("isBanneropt"); %>

<script>  


function check()
{
 if(isBanneropt==true)
 {
  document.getElementById("checkbox1").checked=true;
  }
  else
document.getElementById("checkbox1").checked=false;
}  



    function changeSelected()
    {        
      jsSelectItemByValue(document.getElementById("language"),pf.langpref);  
          }   
             function changeSelected1()
    {        
      jsSelectItemByValue(document.getElementById("fav"),pf.favcategory);  
          }       
             function jsSelectItemByValue(objSelect,objItemText)
              {        
               var selectCount = document.getElementById("language").options;
                for(var i=0;i<objSelect.options.length;i++)
                 {             
                  if(objSelect.options[i].value == objItemText) 
                  {                 
                   objSelect.options[i].selected = true;              
                       break;             
                  }      
                 }     
              }  
  

  
</script>  
  <style>
  #no1{ background-color: #33ccff;width=500px; padding-top:20px;padding-bottom:20px ;text-align: center;}
</style>
<form action="../shop/AccountInformationServlet.do" method="post" >
<TABLE cellpadding=30 cellspacing=30 align=center border=1 bgcolor="#00ccff;" style="margin-top: 50px"><TR><TD>


<div id=no1>
<div style="text-align: center;">
						<table align="right">
							<TR>
								<TD>
									User ID:
								</TD>
								<TD width=250px>
									<input type="hidden" name="USERID" value=${account.userId }>
									${account.userId }
								</TD>
							</TR>
							<TR>
								<TD>
									Password:
								</TD>
								<TD>
									<input name="Password" type="text"
										onblur="if(this.value == '')this.value='${so.password}';"
										onclick="if(this.value == '${so.password}')this.value='';"
										value="${so.password}" />
								</TD>
							</TR>
							<tr>
								<td>
									FirstName:
								</td>
								<td width=250px>
									<font face="Arial"> <input type="text" name="FirstName"
											onblur="if(this.value == '')this.value='${account.firstname}';"
											onclick="if(this.value == '${account.firstname}')this.value='';"
											value="${account.firstname}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">LastName:</font>
								</td>
								<td>
									<font face="Arial"> <input type="text" name="LastName"
											onblur="if(this.value == '')this.value='${account.lastname}';"
											onclick="if(this.value == '${account.lastname}')this.value='';"
											value="${account.lastname}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">Email:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="Email"
											onblur="if(this.value == '')this.value='${account.email}';"
											onclick="if(this.value == '${account.email}')this.value='';"
											value="${account.email}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">Phone:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="Phone"
											onblur="if(this.value == '')this.value='${account.phone}';"
											onclick="if(this.value == '${account.phone}')this.value='';"
											value="${account.phone}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">Address1:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="Address1"
											onblur="if(this.value == '')this.value='${account.addr1}';"
											onclick="if(this.value == '${account.addr1}')this.value='';"
											value="${account.addr1}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">Address2:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="Address2"
											onblur="if(this.value == '')this.value='${account.addr2}';"
											onclick="if(this.value == '${account.addr2}')this.value='';"
											value="${account.addr2}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">City:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="City"
											onblur="if(this.value == '')this.value='${account.city}';"
											onclick="if(this.value == '${account.city}')this.value='';"
											value="${account.city}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">State:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="State"
											onblur="if(this.value == '')this.value='${account.state}';"
											onclick="if(this.value == '${account.state}')this.value='';"
											value="${account.state}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">Zip:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="Zip"
											onblur="if(this.value == '')this.value='${account.zip}';"
											onclick="if(this.value == '${account.zip}')this.value='';"
											value="${account.zip}">
									</font>
								</td>
							</tr>
							<tr>
								<td>
									<font face="Arial">Country:</font>
								</td>
								<td>
									<font face="Arial"><input type="text" name="Country"
											onblur="if(this.value == '')this.value='${account.country}';"
											onclick="if(this.value == '${account.country}')this.value='';"
											value="${account.country}">
									</font>
								</td>
							</tr>
						
						</table>
					</div>
<div>
<div style="text-align: center; color:#33ccff;font-size:40;font-weight: bold; width: 400px " ></div>
</div>
<div style="text-align: center;">
<table  cellspacing="2" cellpadding="2"  style="background-color:#33ccff;margin:0 auto;" >
<tr><td><font face="Arial">Language Preference:</font></td><td><font face="Arial"><select name="language">  
<option>English</option> 
<option>Japanese</option> 
</select></td></tr>
<tr><td>Favourite Category:</td><td><select name="fav"> 
<option>Fish</option>
<option>Dogs</option>
<option>Raptiles</option>
<option>Cats</option>
<option>Birds</option>
</select>
</td></tr>


<tr><td colspan="2"><input type="checkbox" name="checkbox1" value="1"  />  Enable MyList</td></tr>
<tr><td colspan="2"><input type="checkbox" name="checkbox2" value="1"  />  Enable MyBanner</td></tr>
</table>
</div>
</div>
</TABLE>

<BR><CENTER>
<input border=0 type="image" src="../static/img/button_submit.gif" />

</CENTER>

</form>

<%@ include file="IncludeBottom.jsp" %>