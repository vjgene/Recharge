/*$(document).ready(function() {
    $('#history').DataTable({
    	"order": [[ 0, "desc" ]],
    	"sPaginationType": "full_numbers",
        "bServerSide": true,
        "ajax": "/recharge/history.do",
        "sServerMethod": "GET",
        "iDisplayLength": 50
    });
});*/

$(function() {
  });
	function showPopup(oid)	{
		page = '/recharge/rechargeStatus.jsp?txn='+oid;
		var $dialog = $('<div id=\"dialog\"></div>')
               .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
               .dialog({
                   autoOpen: false,
                   modal: false,
                   height: 125,
				   position: ['middle',50],
                   width: 400,
                   title: oid
               });
		$dialog.dialog('open');
}

function loginPostpaid()	{
	document.forms.postpaid.amember_login.value = "happymobiles";
	document.forms.postpaid.amember_pass.value = btoa("z«¶*'");
	document.forms.postpaid.submit();
	//$(this).delay(2000).queue(function(){window.open('http://www.jolo.in/member/panel/paypostpaid.php')});
}

