<jsp:useBean id="codesBean"
	class="com.happysystems.action.RechargeCodes" scope="session" />
<c:set target="${codesBean}" property="type" value="${param.p}" />

<h1>
	<c:out value="${param.p}" />
	&nbsp;Recharge
</h1>

<html:form  action="/recharge">
<div class="form-group col-xs-4">
	<html:hidden property="type" value="<%=request.getParameter(\"p\")%>" />
	
		<label for="number">Number:</label>
		<html:text styleClass="form-control" styleId="number" name="rechargeForm" property="service" value="" />
	


		<label for="amount">Amount:</label>
		<html:text styleId="amount" styleClass="form-control" name="rechargeForm" property="amount" value="" />
	

		<label for="operator">Operator:</label>
		<html:select styleId="operator" styleClass="form-control" name="rechargeForm" property="operator">
	
		<html:optionsCollection name="codesBean" property="codesList" />
	</html:select>
		

	<br />
	<html:submit styleClass="btn btn-default btn-lg btn-info" />
</div>
</html:form>