<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <s:form name="addMessage" action="hello" theme="simple">
   <div>
   		Message: <s:textfield label="Message" name="name"></s:textfield>
   </div>
   <div style="float: right;">
   		<s:textfield label="Message" name="name1"></s:textfield>
   </div>
   </s:form>
</body>
</html>