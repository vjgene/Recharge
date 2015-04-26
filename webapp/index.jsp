<%@include file="header.inc.jsp"%>
<c:choose>
<c:when test="${param.p == 'prepaid' || param.p == 'dth' || param.p == 'data'}">
<%@include file="rc.jsp"%>
</c:when>
<c:when test="${empty param.p || param.p == '' || param.p == 'lastrc'}">
<div class="jumbotron"><h3><c:out value="${rechargeForm.message}"/></h3></div>
</c:when>
<c:when test="${param.p == 'dispute'}">
	<%@include file="dispute.jsp"%>
</c:when>
</c:choose>
<%@include file="footer.inc"%>