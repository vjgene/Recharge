<%@include file="header.inc.jsp"%>
<head>
<link rel="stylesheet" href="css/history.css" />
<script type="text/javascript">
$(document).ready(function () {

$("#history").dataTable({
"bServerSide": true,
"sAjaxSource": "/recharge/history.do",
"bProcessing": true,
"sPaginationType": "full_numbers",
"bJQueryUI": false,
"aoColumns": [{"mData": "id"}, {"mData": "created"},
	{
		"mData": "orderId",
		"mRender": function (data,type,row)                              
                        {
                        	if(data == 'NA')	return	data;                            
                            return "<span class=\"href\" onclick=\"showPopup("+data+")\"/>"+data+"</span>";
					
                        }
	},
	{"mData": "operator"},{"mData": "number"},{"mData": "amount"},{"mData": "response"}]
});
});
</script>
</head>

<table id="history" class="table-striped table-bordered" width="100%" cellspacing="0">
	<thead>
		<th>Sno</th>
		<th>Date</th>
		<th>OrderID</th>
		<th>Oper</th>
		<th>Number</th>
		<th>Rs.</th>
		<th>Response</th>
	</thead>
	<tbody></tbody>
</table>
<div id="test"></div>
<%@include file="footer.inc"%>

