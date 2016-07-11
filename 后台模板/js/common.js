$(document).ready(function() {	
	//复选框
	$('.i-checks').iCheck({
		checkboxClass: 'icheckbox_square-green',
		radioClass: 'iradio_square-green',
	});
	var ifChecked = true;
	$('.check-all').on('click', function(event) {
		if (ifChecked) {
			$('.i-checks').iCheck('check');
			ifChecked = false;
		} else {
			$('.i-checks').iCheck('uncheck');
			ifChecked = true;
		}
	});
});

function comfirmDel(){
	window.location.href="http://baidu.com"
}
