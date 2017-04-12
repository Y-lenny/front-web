// 上下页
function pageInfo(pageNo) {
	$("#pageNo").val(pageNo);
	$("#pageForm").submit();
}

//分页确定
function inputPageNo(pageNo){
	var num = $.trim($("#numberSize").val());
	num = parseInt(num);
	if (isNaN(num)) {
		return;
	} else if (num == ""){
		return;
	} else if (num<1){
		return;
	} else if (num > pageNo){
		return;
	} else {
		$("#pageNo").val(num);
		$("#pageForm").submit();
	}
}

//每页显示条数
function pageSize(size){
	$("#pageNo").val(1);
	$("#pageSize").val(size);
	$("#pageForm").submit();
}

function genPageNavigation(page, pageCount, rowCount, start, end, loadData) {
	var nav = "<div class='col-md-5 col-sm-12'>"
			+"<div class='dataTables_info'>";
	if (rowCount == 0) {
		nav += "总共" + rowCount + "条";
	} else {
		nav += "显示  " + (start + 1) + " to " + end + " 总共" + rowCount + "条";
	}
	nav += "</div></div>";
	if (rowCount > 0) {
		nav += "<div class='col-md-7 col-sm-12'>";
		nav += "<div class='dataTables_paginate paging_bootstrap'>";
		nav += "<div class='pagination' style='visibility: visible;'>";
		if (page == 1) {
			nav += "<li class='prev disabled'>";
		} else {
			nav += "<li class='prev'>";
		}
		nav += "<a href=\"javascript:"+loadData+"('" + ((page - 1) < 1 ? 1:(page-1)) + "');\" title='Prev'>";
		nav += "<i class='fa fa-angle-left'></i></a></li>";

		var sp = 1;
		var ep = pageCount > 10 ? 10 : pageCount;

		if (page > 6) {
			sp = page - 5;
			ep = sp + 9;
			if (ep > pageCount) {
				ep = pageCount;
			}
		}
		for (var i = sp; i <= ep; i++) {
			if (i == page) {
				nav += "<li class='active'>";
			} else {
				nav += "<li>";
			}
			nav += "<a href=\"javascript:"+loadData+"('" + i + "');\">" + i + "</a></li>";
		}

		if (page == pageCount) {
			nav += "<li class='next disabled'>";
		} else {
			nav += "<li class='next'>";
		}
		nav += "<a href=\"javascript:"+loadData+"('" + ((page+1) > pageCount ? pageCount:(page+1)) + "')\" title='Next'>";
		nav += "<i class='fa fa-angle-right'></i></a></li>";
		nav += "</ul></div></div>";
	}
	return nav;
}