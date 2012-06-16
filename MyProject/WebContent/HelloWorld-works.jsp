<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Untitled Document</title>
<style type="text/css">
.bar {
	background: none repeat scroll 0 0 #F1F1F1;
    border-bottom: 1px solid #E5E5E5;
    height: 71px;
    overflow: hidden;

}.logo {
    float: left;
    margin: 10px 150px 20px;
	width:270px;
	
	
}

.login {
    float:right;
    margin: 20px 140px 20px;
	width:200px;
	
}
/* REGULAR */

button.regular, .buttons a.regular{
    color:#336699;
	width:100px;
	height:30px;
	background-color:#D0EFFF;
	    display:block;
    float:left;
    margin:0 7px 0 0;
    background-color:#D14836;
    border:1px solid #f65e4b;
    font-family:"Lucida Grande", Tahoma, Arial, Verdana, sans-serif;
    font-size:12px;
    line-height:130%;
    text-decoration:none;
    font-weight:bold;
    color:#FFFFFF;
    cursor:pointer;
    padding:5px 10px 6px 7px; /* Links */
	-moz-border-radius-bottomleft:1px;
	-moz-border-radius-bottomright:1px;
	-moz-border-radius-topleft:1px;
	-moz-border-radius-topright:1px;
	border-top-right-radius: 1px 1px;
	border-top-left-radius: 1px 1px;
	border-bottom-left-radius: 1px 1px;
	border-bottom-right-radius: 1px 1px;
	width:100px;
	height:30px;
}
.buttons a.regular:hover, button.regular:hover{
    background-color:#ae1d0a;
     border:1px solid #f65e4b;
    color:#FFFFFF;
	width:100px;
	height:30px;
}
.buttons a.regular:active{
    background-color:#6299c5;
     border:1px solid #f65e4b;
    color:#fff;
	width:100px;
	height:30px;
}
.box {
    background: none repeat scroll 0 0 #F1F1F1;
    border: 1px solid #E5E5E5;
    margin: 6px 2px 0;
	float: left;
    padding: 5px 5px 5px;
	width:300px;
}
.lokasyon {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 20px;
}
.lokasyon_1 {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 20px;
	color:#F00;
}
.lokasyon_2 {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 20px;
	color:#09F;
}

.lokasyon_3 {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 20px;
	color:#66CC33;
}
.user_name {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 13px;
	color:#626365;
}
.time {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 11px;
	color:#858383;
}
.text {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 14px;
	color:#000000;
}
.yorum{
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 14px;
	color:#999;
	width:285px;
	}
.text_com{
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 13px;
	color:#6A6557
	}

</style>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<div class="bar">


  <div class="logo"><img src="/images/logo.png" width="179" height="56" align="right" />
  </div>
  
  
  <div class="login">
    <button type="submit" class="regular" name="yeni" value="BaÅtan BaÅla" onclick="kontrolEt();">
        GIRIS YAP
    </button>
  </div>

</div>

<div>
<table align="center">
<tr>
<td valign="top">
<div id="1" class="box">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td>
      	<s:form name="addGlobal" id="addGlobalId" action="hello" theme="simple">
	      <table width="100%" border="0">
	        <tr>
	          <td width="31"><img src="/images/nokta.png" width="31" height="44" /></td>
	          <td width="187" class="lokasyon">${ipLocation.countryCode }<input type="text" name="globalMessage.message"/></td>
	          <td width="62" class="lokasyon_1">+ <s:submit name="s" value="ekle"></s:submit> </td>
	        </tr>
	      </table>
      	</s:form>
      </td>
    </tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    
    <s:iterator value="%{globalMessageList}" id="globalMessages">
    <tr>
      <td>
      <table width="100%" border="0">
        <tr>
          <td width="15%" rowspan="2" valign="top"><img src="/images/veli.jpg" width="40" height="40" /></td>
          <td width="59%" class="user_name">${globalMessages.firstName}</td>
          <td width="26%" align="right" class="time">${globalMessages.stringDate}</td>
        </tr>
        <tr>
          <td colspan="2" class="text">${globalMessages.message}</td>
          </tr>
      </table></td>
    </tr>
    
		<tr>
			<td colspan="3" valign="top">
				<s:form name="addGlobal_%{#globalMessages.id}" id="addGlobalId_%{#globalMessages.id}" action="hello" theme="simple">
					<s:hidden name="globalMessage.id" value="%{#globalMessages.id}" id="addGlobalCommentId_%{#globalMessages.id}"/>
					<input type="text" onblur="if(this.value=='') this.value='Yorum ?';" onkeypress="return submitThisForm('addGlobalId_${globalMessages.id}');" onfocus="this.value = '';" value="Yorum yaz.." title="3-mail" size="30" id="email" name="email" maxlength="100" class="yorum"/>
					
				</s:form>
          
<%-- 
				<input type="text" onblur="if(this.value=='') this.value='Yorum ?';" onfocus="this.value = '';" value="Yorum yaz.." title="3-mail" size="30" id="email" name="email" maxlength="100" class="yorum"></td>
--%>
			</td>
		</tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    </s:iterator>
       <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
      <tr>
      <td><table width="100%" border="0">
        <tr>
          <td width="15%" align="right" valign="top"><img src="/images/kafa.jpg" width="30" height="30" /></td>
          <td class="text_com"><b>Ali TÃ¼rkmen : </b>Merhaba lar Ã§ok gÃ¼zel gÃ¶zÃ¼kÃ¼yor iyi Ã§alÄ±Åmalar</td>
        </tr>
        </table></td>
    </tr>
       <tr>
          <td colspan="3" valign="top">
          <input type="text" onblur="if(this.value=='') this.value='Yorum ?';" onkeypress="submitThisForm()" onfocus="this.value = '';" value="Yorum yaz.." title="3-mail" size="30" id="email" name="email" maxlength="100" class="yorum"></td>
          </tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    
  </table>
</div>

</td>
<td valign="top">
<div id="1" class="box">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td>
		<s:form name="addPublic" id="addPublicId" action="hello" theme="simple">
	      <table width="100%" border="0">
	        <tr>
	          <td width="31"><img src="/images/nokta.png" width="31" height="44" /></td>
	          <td width="187" class="lokasyon">${ipLocation.cityName }<input type="text" name="publicMessage.message"/></td>
	          <td width="62" class="lokasyon_1">+ <s:submit name="s" value="ekle"></s:submit> </td>
	        </tr>
	      </table>
      	</s:form>
      </td>
    </tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    <s:iterator value="%{publicMessageList}" id="publicMessages">
    <tr>
      <td>
      <table width="100%" border="0">
        <tr>
          <td width="15%" rowspan="2" valign="top"><img src="/images/veli.jpg" width="40" height="40" /></td>
          <td width="59%" class="user_name">Veli CoÅkun</td>
          <td width="26%" align="right" class="time">${publicMessages.stringDate}</td>
        </tr>
        <tr>
          <td colspan="2" class="text">${publicMessages.message}</td>
          </tr>
      </table></td>
    </tr>
    
    </tr>
         <tr>
          <td colspan="3" valign="top">
          <input type="text" onblur="if(this.value=='') this.value='Yorum ?';" onfocus="this.value = '';" value="Yorum yaz.." title="3-mail" size="30" id="email" name="email" maxlength="100" class="yorum"></td>
          </tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    </s:iterator>
</table>
 
</div>
</td>
<td valign="top">
<div id="1" class="box">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td>
		<s:form name="addSpecial" id="addSpecialId" action="hello" theme="simple">
	      <table width="100%" border="0">
	        <tr>
	          <td width="31"><img src="/images/nokta.png" width="31" height="44" /></td>
	          <td width="187" class="lokasyon">${ipLocation.companyNameSpecial }<input type="text" name="specialMessage.message"/></td>
	          <td width="62" class="lokasyon_1">+ <s:submit name="s" value="ekle"></s:submit> </td>
	        </tr>
	      </table>
      	</s:form>
      </td>
    </tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    <s:iterator value="%{specialMessageList}" id="specialMessages">
    <tr>
      <td>
      <table width="100%" border="0">
        <tr>
          <td width="15%" rowspan="2" valign="top"><img src="/images/veli.jpg" width="40" height="40" /></td>
          <td width="59%" class="user_name">Veli CoÅkun</td>
          <td width="26%" align="right" class="time">${specialMessages.stringDate}</td>
        </tr>
        <tr>
          <td colspan="2" class="text">${specialMessages.message}</td>
          </tr>
      </table></td>
    </tr>
    <tr>
          <td colspan="3" valign="top">
          <input type="text" onblur="if(this.value=='') this.value='Yorum ?';" onfocus="this.value = '';" value="Yorum yaz.." title="3-mail" size="30" id="email" name="email" maxlength="100" class="yorum"></td>
          </tr>
    <tr>
      <td><hr size="1" color="#d9d4d4"></td>
    </tr>
    </s:iterator>
  </table>

</div></td>
</tr>
</table>

</div>

</body>
</html>
