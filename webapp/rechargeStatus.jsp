<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<c:set var="url" value="http://jolo.in/api/rechargestatus.php?userid=happymobiles&txn=${param.txn}"/>
<c:import url="${url}"/>
