<%@include file="/init.jsp" %>
 <div class="modal hide fade" id="add-article">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">x</button>
                    <ul class="nav nav-pills area-list">
                        <li id="messageCountryId">
                            <a href="#" onclick="$('#messageTypeId').attr('value',1);$('#messageCityId').attr('class','passive');$('#messageCountryId').attr('class','active');$('#messageCompanyId').attr('class','passive');">${ipLocation.countryCode }</a>
                        </li>
                        <li id="messageCityId">
                            <a href="#" onclick="$('#messageTypeId').attr('value',2);$('#messageCityId').attr('class','active');$('#messageCountryId').attr('class','passive');$('#messageCompanyId').attr('class','passive');">${ipLocation.cityName }</a>
                        </li>
                        <li id="messageCompanyId">
                            <a href="#" onclick="$('#messageTypeId').attr('value',3);$('#messageCityId').attr('class','passive');$('#messageCountryId').attr('class','passive');$('#messageCompanyId').attr('class','active');">${ipLocation.companyNameSpecial }</a>
                        </li>
                    </ul>
                </div>
                <div class="modal-body">
                    
                        <s:form name="addGlobal" id="addGlobalId" action="hello" theme="simple">
                            <fieldset>
                                <div class="control-group">
                                    <div class="controls">
                                    	<s:hidden name="messageType" value="1" id="messageTypeId"/>
										<textarea id="textarea" name="generalMessage.message" class="input-xlarge" rows="3" placeholder="Etrafindakilere ne demek istersin?" style="width: 98%; height: 67px;"></textarea>
									</div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" class="input-large" id="input01" placeholder="Etiket belirleyin..">
                                    <div class="btn-group pull-right">
									  <button class="btn"><i class="icon-file"></i></button>
									  <button class="btn"><i class="icon-camera"></i></button>
									  <button class="btn"><i class="icon-facetime-video"></i></button>
									</div>
									</div>
									
                                </div>
                                <div class="form-actions">
                                    <button class="btn btn-primary btn-large-width" type="submit">Gönder</button>
                                </div>
                            </fieldset>
                        </s:form>
                       
                </div>
                    <div class="modal-footer">
                </div>
        </div>
        