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
              
                
              
              
              <a class="brand" href="#">Wallony</a>             
            </div>
          </div>
        </div>
                    
        <div class="container capsule">
          <div class="row columns">
            <div class="span4 col-wrap">
            	<div class="col-header">
                	<span class="head-pin"><h1>${ipLocation.countryCode }</h1></span>
                    <button class="btn pull-right btn-add" data-toggle="modal" href="#add-article" onclick="$('#messageTypeId').attr('value',1);$('#messageCityId').attr('class','passive');$('#messageCountryId').attr('class','active');$('#messageCompanyId').attr('class','passive');">
                        <i class="icon-plus"></i>
                        Ekle
                    </button>
                </div>
                <div class="col-body">
                
                
                <s:iterator value="%{globalMessageList}" id="globalMessages">
                    <div class="article-content">
                    	
                    	<s:if test="%{globalMessages.photo!=null}">
	                    	<div class="row">
	                        	<div class="media span4">
	                           		<a class="thumbnail" href="#">
	                                	<img alt="" src="http://placehold.it/350x150">
	                                </a>
	                            </div>
	                        </div>
                    	</s:if>
                        <div class="row">
                            <div class="avatar span1">
                       	    	<a href="#"><img src="/img/picture.jpg" width="50" height="50" /></a> 
                            </div>
                            <div class="span3 article-body">
                            	<div class="article-head">
                                	<a href="#"><h2>${globalMessages.name}</h2></a>
                                  <span class="time">${globalMessages.stringDate}</span>
                                </div>
                                <p>
                                	${globalMessages.message}
                             	</p>
								<div class="article-foot">
                                  <s:if test="%{globalMessages.video!=null}">
									<div class="video-thumb">
									  <a data-toggle="modal" href="#video-embed">
				                                    	<i class="video-overlay"></i>
				                                        <img src="http://external.ak.fbcdn.net/safe_image.php?d=AQB0onPHDLi-ElAt&w=130&h=130&url=http%3A%2F%2Fi2.ytimg.com%2Fvi%2F-s7i3360WYE%2Fhqdefault.jpg">
				                     </a> 
                                     <span class="video-meta">
                                     	<p><a href="http://www.youtube.com/watch?v=2VlzpwLu-iQ&feature=g-u-u" target="_blank">CumhurbaÅkanÄ± GÃ¼l, TRT Haber'de Sosyal Medya </a></p>
                                     	<p><a href="http://www.youtube.com" target="_blank">www.youtube.com</a></p>
                                     </span>
								  </div>
								</s:if>
								<div class="article-comment">
									<a href="#" id="add-comment">Yorum yap</a> &nbsp; <a href="#">Yukselt</a>
									<a href="#" class="pull-right">Ac</a>
									<div class="comment-form">
										<form>
											<input type="text" class="span3" placeholder="Yorum ekle">
										</form>
									</div>
								</div>									
							  </div>
                            </div>
                        </div>
                    </div>
                  </s:iterator>
                </div>
            </div>
            <div class="span4 col-wrap">
            	<div class="col-header">
                	<span class="head-pin"><h1>${ipLocation.cityName }</h1></span>
                    <button class="btn pull-right btn-add" data-toggle="modal" href="#add-article" onclick="$('#messageTypeId').attr('value',2);$('#messageCityId').attr('class','active');$('#messageCountryId').attr('class','passive');$('#messageCompanyId').attr('class','passive');">
                        <i class="icon-plus"></i>
                        Ekle
                    </button>
                </div>
                <div class="col-body">
                	
                    
                <s:iterator value="%{publicMessageList}" id="globalMessages">
                    <div class="article-content">
                    	
                    	<s:if test="%{globalMessages.photo!=null}">
	                    	<div class="row">
	                        	<div class="media span4">
	                           		<a class="thumbnail" href="#">
	                                	<img alt="" src="http://placehold.it/350x150">
	                                </a>
	                            </div>
	                        </div>
                    	</s:if>
                        <div class="row">
                            <div class="avatar span1">
                       	    	<a href="#"><img src="/img/picture.jpg" width="50" height="50" /></a> 
                            </div>
                            <div class="span3 article-body">
                            	<div class="article-head">
                                	<a href="#"><h2>${globalMessages.name}</h2></a>
                                  <span class="time">${globalMessages.stringDate}</span>
                                </div>
                                <p>
                                	${globalMessages.message}
                             	</p>
								<div class="article-foot">
                                  <s:if test="%{globalMessages.video!=null}">
									<div class="video-thumb">
									  <a data-toggle="modal" href="#video-embed">
				                                    	<i class="video-overlay"></i>
				                                        <img src="http://external.ak.fbcdn.net/safe_image.php?d=AQB0onPHDLi-ElAt&w=130&h=130&url=http%3A%2F%2Fi2.ytimg.com%2Fvi%2F-s7i3360WYE%2Fhqdefault.jpg">
				                     </a> 
                                     <span class="video-meta">
                                     	<p><a href="http://www.youtube.com/watch?v=2VlzpwLu-iQ&feature=g-u-u" target="_blank">CumhurbaÅkanÄ± GÃ¼l, TRT Haber'de Sosyal Medya </a></p>
                                     	<p><a href="http://www.youtube.com" target="_blank">www.youtube.com</a></p>
                                     </span>
								  </div>
								</s:if>
								<div class="article-comment">
									<a href="#" id="add-comment">Yorum yap</a> &nbsp; <a href="#">Yukselt</a>
									<a href="#" class="pull-right">Ac</a>
									<div class="comment-form">
										<form>
											<input type="text" class="span3" placeholder="Yorum ekle">
										</form>
									</div>
								</div>									
							  </div>
                            </div>
                        </div>
                    </div>
                  </s:iterator>
                    
                    
                </div>
            </div>
            <div class="span4 col-wrap">
            	<div class="col-header">
                	<span class="head-pin"><h1>${ipLocation.companyNameSpecial }</h1></span>
                    <button class="btn pull-right btn-add" data-toggle="modal" href="#add-article" onclick="$('#messageTypeId').attr('value',3);$('#messageCityId').attr('class','passive');$('#messageCountryId').attr('class','passive');$('#messageCompanyId').attr('class','active');">
                        <i class="icon-plus"></i>
                        Ekle
                    </button>
                </div>
                <div class="col-body">
                 <s:iterator value="%{specialMessageList}" id="globalMessages">
                    <div class="article-content">
                    	
                    	<s:if test="%{globalMessages.photo!=null}">
	                    	<div class="row">
	                        	<div class="media span4">
	                           		<a class="thumbnail" href="#">
	                                	<img alt="" src="http://placehold.it/350x150">
	                                </a>
	                            </div>
	                        </div>
                    	</s:if>
                        <div class="row">
                            <div class="avatar span1">
                       	    	<a href="#"><img src="/img/picture.jpg" width="50" height="50" /></a> 
                            </div>
                            <div class="span3 article-body">
                            	<div class="article-head">
                                	<a href="#"><h2>${globalMessages.name}</h2></a>
                                  <span class="time">${globalMessages.stringDate}</span>
                                </div>
                                <p>
                                	${globalMessages.message}
                             	</p>
								<div class="article-foot">
                                  <s:if test="%{globalMessages.video!=null}">
									<div class="video-thumb">
									  <a data-toggle="modal" href="#video-embed">
				                                    	<i class="video-overlay"></i>
				                                        <img src="http://external.ak.fbcdn.net/safe_image.php?d=AQB0onPHDLi-ElAt&w=130&h=130&url=http%3A%2F%2Fi2.ytimg.com%2Fvi%2F-s7i3360WYE%2Fhqdefault.jpg">
				                     </a> 
                                     <span class="video-meta">
                                     	<p><a href="http://www.youtube.com/watch?v=2VlzpwLu-iQ&feature=g-u-u" target="_blank">CumhurbaÅkanÄ± GÃ¼l, TRT Haber'de Sosyal Medya </a></p>
                                     	<p><a href="http://www.youtube.com" target="_blank">www.youtube.com</a></p>
                                     </span>
								  </div>
								</s:if>
								<div class="article-comment">
									<a href="#" id="add-comment">Yorum yap</a> &nbsp; <a href="#">Yukselt</a>
									<a href="#" class="pull-right">Ac</a>
									<div class="comment-form">
										<form>
											<input type="text" class="span3" placeholder="Yorum ekle">
										</form>
									</div>
								</div>									
							  </div>
                            </div>
                        </div>
                    </div>
                  </s:iterator>               
                </div>
            </div>
          </div>
    
    
        </div> <!-- /container -->
        
         <%@include file="/messages/add-new-message.jsp" %>
     	<!-- 
        <div class="modal hide fade" id="add-article">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">Ã</button>
                    <ul class="nav nav-pills area-list">
                        <li class="active">
                            <a href="#">TÃ¼rkiye</a>
                        </li>
                        <li>
                            <a href="#">Ä°stanbul</a>
                        </li>
                        <li>
                            <a href="#">Feza Gazetecilik</a>
                        </li>
                    </ul>
                </div>
                <div class="modal-body">
                    
                        <form class="form-horizontal">
                            <fieldset>
                                <div class="control-group">
                                    <div class="controls">
										<textarea id="textarea"  class="input-xlarge" rows="3" placeholder="EtrafÄ±ndakilere ne demek istersin?" style="width: 98%; height: 67px;"></textarea>
									</div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" class="input-large" id="input01" placeholder="Etiket belirleyin..">
                                    <div class="btn-group pull-right">
									  <a id="media-toggle" class="btn"><i class="icon-file"></i></a>
									  <a id="img-toggle" class="btn"><i class="icon-camera"></i></a>
									  <a id="media-toggle" class="btn"><i class="icon-facetime-video"></i></a>
									</div>
                                    <div class="img-btn-form input-prepend">
                                        <form>
                                        	<span class="add-on"><i class="icon-file"></i></span>
                                        	<input type="text" id="prependedInput" class="span3 input-xlarge" placeholder="BaÄlantÄ± ekle">
                                        </form>
                                    </div>
									</div>
									
                                </div>
                                <div class="form-actions">
                                    <button class="btn btn-primary btn-large-width" type="submit">GÃ¶nder</button>
                                </div>
                            </fieldset>
                        </form>
                       
                </div>
                    <div class="modal-footer">
                </div>
        </div>
        -->
        <div class="modal hide fade" id="user-login">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">Ã</button>
                    <h3>KullanÄ±cÄ± GiriÅi</h3>
                </div>
                <div class="modal-body">
                    
                </div>
                    <div class="modal-footer">
                </div>
        </div>
        
        <div class="modal hide fade modal-video" id="video-embed">
			
                    <button class="close"style="color:white;" data-dismiss="modal">Ã</button>
                <div class="modal-body">
					<iframe width="640" height="390" src="http://www.youtube.com/embed/2VlzpwLu-iQ" frameborder="0" allowfullscreen></iframe>
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
	
    <script>
		$("#add-comment").click(function () {
		  $(".comment-form").fadeToggle("fast", function () {
		   });
		});
		$("#img-toggle").click(function () {
		  $(".img-btn-form").fadeToggle("fast", function () {
		   });
		});
	</script>
  </body>
</html>
