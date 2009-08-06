<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr" %>

<h2><bean:message key="acquisitionRequestItem.title.edit" bundle="ACQUISITION_RESOURCES"/></h2>

<jsp:include page="../commons/defaultErrorDisplay.jsp"/>

<bean:define id="processOID" name="itemBean" property="acquisitionRequest.acquisitionProcess.externalId" type="java.lang.String"/>
<bean:define id="processClass" name="itemBean" property="acquisitionRequest.acquisitionProcess.class.simpleName"/>
<bean:define id="actionMapping" value="<%= "/acquisition" + processClass%>"/>
<bean:define id="itemOID" name="itemBean" property="item.externalId" type="java.lang.String"/>

<bean:define id="urlView"><%=actionMapping %>.do?method=viewAcquisitionProcess&acquisitionProcessOid=<%= processOID %></bean:define>
<fr:form action='<%= actionMapping + ".do?method=executeAcquisitionRequestItemEdition&acquisitionProcessOid="  + processOID + "&acquisitionRequestItemOid=" + itemOID%>'> 

<fr:edit id="acquisitionRequestItem" name="itemBean"  visible="false"/>

<h3><bean:message key="acquisitionProcess.title.description" bundle="ACQUISITION_RESOURCES"/></h3>

<div  class="form1">
	<fr:edit id="acquisitionRequestItem.block1" name="itemBean" schema="createAcquisitionRequestItem.block1">
		<fr:layout name="tabular">
			<fr:property name="classes" value="form thwidth150px"/>
			<fr:property name="columnClasses" value=",,tderror"/>
		</fr:layout>
		<fr:destination name="cancel" path="<%= urlView %>" />
		<fr:destination name="invalid" path='<%= actionMapping + ".do?method=executeCreateAcquisitionRequestItem&acquisitionProcessOid=" + processOID %>'/>
		<fr:destination name="postBack" path="<%= actionMapping + ".do?method=editItemPostBack" %>"/>
	</fr:edit>
</div>

<h3><bean:message key="acquisitionProcess.title.quantityAndCosts" bundle="ACQUISITION_RESOURCES"/></h3>

<div  class="form1">
	<fr:edit id="acquisitionRequestItem.block2" name="itemBean" schema="createAcquisitionRequestItem.block2">
		<fr:layout name="tabular">
			<fr:property name="classes" value="form thwidth150px"/>
			<fr:property name="columnClasses" value=",,tderror"/>
		</fr:layout>
		<fr:destination name="cancel" path="<%= urlView %>" />
		<fr:destination name="invalid" path='<%= "/acquisitionProcess.do?method=executeCreateAcquisitionRequestItem&acquisitionProcessOid=" + processOID %>'/>
		<fr:destination name="postBack" path="<%= actionMapping + ".do?method=editItemPostBack" %>"/>
	</fr:edit>
</div>

<h3><bean:message key="acquisitionProcess.title.deliveryInformation" bundle="ACQUISITION_RESOURCES"/></h3>

<bean:define id="schemaType"
		name="itemBean"
		property="createItemSchemaType"/>
		
<div  class="form1">
	<fr:edit id="acquisitionRequestItem.block3" name="itemBean" schema="<%= "createAcquisitionRequestItem.block3_" + schemaType.toString() %>">
		<fr:layout name="tabular">
			<fr:property name="classes" value="form thwidth150px"/>
			<fr:property name="columnClasses" value=",,tderror"/>
		</fr:layout>
		<fr:destination name="postBack" path="<%= actionMapping + ".do?method=editItemPostBack" %>"/>
	</fr:edit>
</div>

<p>
	<html:submit styleClass="inputbutton"><bean:message key="renderers.form.submit.name" bundle="RENDERER_RESOURCES"/></html:submit>
	<html:cancel styleClass="inputbutton"><bean:message key="renderers.form.cancel.name" bundle="RENDERER_RESOURCES"/></html:cancel>
</p>
</fr:form>