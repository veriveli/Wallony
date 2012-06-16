<!DOCTYPE html>
<%@include file="/init.jsp" %>
<html><head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	
    

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link type="text/css" href="css/jquery.jscrollpane.css" rel="stylesheet" media="all" />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body>
        <div class="navbar navbar-fixed-top">
          <div class="navbar-inner">
            <div class="container">
              <button class="btn btn-warning pull-right btn-large-width" data-toggle="modal" href="#user-login">
                Giriş Yap
              </button>
              
                
              
              
              <a class="brand" href="#">Project name</a>             
            </div>
          </div>
        </div>
                    
        <div class="container capsule">
          <div class="row columns">
            <div class="span4 col-wrap">
            	<div class="col-header">
                	<span class="head-pin"><h1>${ipLocation.countryCode }</h1></span>
                    <button class="btn pull-right btn-add" data-toggle="modal" href="#add-article"  onclick="$('#messageTypeId').attr('value',1);">
                        <i class="icon-plus"></i>
                        Ekle
                    </button>
                </div>
                <div class="col-body">                	
				    <s:iterator value="%{globalMessageList}" id="globalMessages">
					    <div style="float: left;width: 15%;"><img src="/images/veli.jpg" width="40" height="40" /></div>
					    <div style="float: left;width: 85%;">
					    	<div style="float: left;width: 59%;">Veli Coskun</div>
					    	<div style="float: left;width: 26%;" class="time">${globalMessages.stringDate}</div>
					    	<div style="float: left;width: 85%;" class="text">${globalMessages.message}</div>
					    </div>
					    <div style="clear: both;"></div>
					    <div>
					    	<s:iterator id="comment" value="%{#globalMessages.messagesList}">
					    		${comment.message }<br>
					    	</s:iterator>
					    	<s:form name="addGlobal_%{#globalMessages.id}" id="addGlobalId_%{#globalMessages.id}" action="hello" theme="simple">
								<s:hidden name="globalMessage.messageId" value="%{#globalMessages.id}" id="addGlobalCommentId_%{#globalMessages.id}"/>
								<input type="text" class="input-large" id="globalCommentId" placeholder="Yorum yaz.." name="globalMessage.message" onkeypress="return submitThisForm(this,event,'addGlobalId_${globalMessages.id}');" />
							</s:form>
					    </div>
				      	<div>
					    	<hr size="1" color="#d9d4d4">
				      	</div>
					</s:iterator>                	
                </div>
            </div>
            <div class="span4 col-wrap">
            	<div class="col-header">
                	<span class="head-pin"><h1>${ipLocation.cityName }</h1></span>
                    <button class="btn pull-right btn-add" data-toggle="modal" href="#add-article" onclick="$('#messageTypeId').attr('value',2);">
                        <i class="icon-plus"></i>
                         Ekle
                    </button>
                </div>
                <div class="col-body">
				    <s:iterator value="%{publicMessageList}" id="publicMessages">
					    <div style="float: left;width: 15%;"><img src="/images/veli.jpg" width="40" height="40" /></div>
					    <div style="float: left;width: 85%;">
					    	<div style="float: left;width: 59%;">Veli Coskun</div>
					    	<div style="float: left;width: 26%;" class="time">${publicMessages.stringDate}</div>
					    	<div style="float: left;width: 85%;" class="text">${publicMessages.message}</div>
					    </div>
					    <div style="clear: both;"></div>
					    <div>
					    	<s:iterator id="comment" value="%{#publicMessages.messagesList}">
					    		${comment.message }<br>
					    	</s:iterator>
					    	<s:form name="addPublic_%{#publicMessages.id}" id="addPublicId_%{#publicMessages.id}" action="hello" theme="simple">
								<s:hidden name="publicMessage.messageId" value="%{#publicMessages.id}" id="addPublicCommentId_%{#publicMessages.id}"/>
								<input type="text" class="input-large" id="publicCommentId" placeholder="Yorum yaz.." name="publicMessage.message" onkeypress="return submitThisForm(this,event,'addPublicId_${publicMessages.id}');"/>
							</s:form>
					    </div>
				      	<div>
					    	<hr size="1" color="#d9d4d4">
				      	</div>
					</s:iterator>
                </div>
            </div>
            <div class="span4 col-wrap">
            	<div class="col-header">
                	<span class="head-pin"><h1>${ipLocation.companyNameSpecial }</h1></span>
                    <button class="btn pull-right btn-add" data-toggle="modal" href="#add-article" onclick="$('#messageTypeId').attr('value',3);">
                        <i class="icon-plus"></i>
                         Ekle
                    </button>
                </div>
                <div class="col-body">
				    <s:iterator value="%{specialMessageList}" id="specialMessages">
					    <div style="float: left;width: 15%;"><img src="/images/veli.jpg" width="40" height="40" /></div>
					    <div style="float: left;width: 85%;">
					    	<div style="float: left;width: 59%;">Veli Coskun</div>
					    	<div style="float: left;width: 26%;" class="time">${specialMessages.stringDate}</div>
					    	<div style="float: left;width: 85%;" class="text">${specialMessages.message}</div>
					    </div>
					    <div style="clear: both;"></div>
					    <div>
					    	<s:iterator id="comment" value="%{#specialMessages.messagesList}">
					    		${comment.message }<br>
					    	</s:iterator>
					    	<s:form name="addSpecial_%{#specialMessages.id}" id="addSpecialId_%{#specialMessages.id}" action="hello" theme="simple">
								<s:hidden name="specialMessage.messageId" value="%{#specialMessages.id}" id="addSpecialCommentId_%{#specialMessages.id}"/>
								<input type="text" class="input-large" id="input01" placeholder="Yorum yaz.." name="specialMessage.message" onkeypress="return submitThisForm(this,event,'addSpecialId_${specialMessages.id}');">
							</s:form>
					    </div>
				      	<div>
					    	<hr size="1" color="#d9d4d4">
				      	</div>
					</s:iterator>
                </div>
            </div>
          </div>
    
    
        </div> <!-- /container -->
        
        <%@include file="/messages/add-new-message.jsp" %>
       
        <div class="modal hide fade" id="user-login">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">Ã</button>
                    <h3>KullanÄ±cÄ± GiriÅi</h3>
                </div>
                <div class="modal-body">
                    <p></p>
                </div>
                    <div class="modal-footer">
                </div>
        </div>
    <!-- Le javascript
    ================================================== -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>

	<script type="text/javascript">
	function submitThisForm(myfield,e,formId) 
	{ 
		
	var keycode; 
	if (window.event) keycode = window.event.keyCode; 
	else if (e) keycode = e.which; 
	else return true; 

	if (keycode == 13) 
	{ 

	//alert('hi'); 
	$('#'+formId).submit(); 
	return false; 
	} 
	else 
	return true; 
	} 
	</script>
  </body>
</html>
