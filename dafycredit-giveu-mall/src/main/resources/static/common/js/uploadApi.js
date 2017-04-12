//普通上传
var Cloud_upload = function(fileObj, type, progress, callback) {
	var f = fileObj[0].files[0];
	var UploadUrl = "/tools/upload.shtml";
    var xhr = new XMLHttpRequest();
    xhr.open('POST', UploadUrl, true);
    var formData, startDate=0;
    formData = new FormData();
    if(type) {
        formData.append('type', type);
    }
    if(f) {
        formData.append('file', f);
    }

    var taking;
    xhr.upload.addEventListener("progress", function(evt) {
        if (evt.lengthComputable) {
            var nowDate = new Date().getTime();
            taking = nowDate - startDate;
            var x = (evt.loaded) / 1024;
            var y = taking / 1000;
            var uploadSpeed = (x / y);
            var formatSpeed = "";
            if (uploadSpeed > 1024) {
                formatSpeed = (uploadSpeed / 1024).toFixed(2) + "Mb\/s";
            } else {
                formatSpeed = uploadSpeed.toFixed(2) + "Kb\/s";
            }
            var percentComplete = Math.round(evt.loaded * 100 / evt.total);
            console && console.log(percentComplete, ",", formatSpeed);
           var progressbar;
            if(progress) {
            	progressbar = $("#"+progress);
            } else {
            	progressbar = fileObj.closest(".js-uploadDiv").find(".progress");
            }
            if(progressbar) {
	       		 var progressLabel = progressbar.find(".progress-bar");
	       	     //progressbar.show();
	       	    
		       	 progressLabel.attr("aria-valuenow", parseInt(percentComplete));
		       	 progressLabel.css("width", percentComplete + "%");
		       	 progressLabel.html(percentComplete + "%");
            }
        }
    }, false);

    xhr.onreadystatechange = function(response) {
        if (xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
            var blkRet = JSON.parse(xhr.responseText);
            console && console.log(blkRet);
            if(typeof callback == 'function') {
            	callback(blkRet);

                var loadObj = $(".loading");
                if(loadObj) {
                    loadObj.hide();
                }
            }
        } else if (xhr.status != 200 && xhr.responseText) {

        }
    };
    startDate = new Date().getTime();
    xhr.send(formData);
};
	        
function uploadFile(file, type, progress, callback) {
    var fileObj;
    if(file instanceof jQuery) {
    	fileObj = file;
    } else {
    	fileObj = $("#"+file);
    }
    
    fileObj.unbind("change");
    fileObj.change(function() {
        var loadObj = $(".loading");
        if(loadObj) {
            loadObj.hide();
        }
        if (fileObj[0].files.length > 0) {

            if(loadObj) {
                loadObj.show();
            }
            Cloud_upload(fileObj, type, progress, callback);
        } else {
            console && console.log("form input error");
        }
    });
}

function validateImage(fileId, width, height, size){
    var file = $('file').value;
    if(!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(file)){
           alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
           if(a==1){
            return false;
           }
    } else {
        var image = new image();
        image.src = file;
        var h = image.height;
        var w = image.width;
        var s = image.filesize;
        
        if(typeof(width) != "undefined" && typeof(height) != "undefined") {
        	
        } else if(typeof(width) != "undefined") {
        	
        } else if(typeof(height) != "undefined") {
        	
        }
        
        if(typeof(size) != "undefined") {
        	
        }
        
        if(width>80 && height>80 && filesize>102400){
         alert('请上传80*80像素 或者大小小于100k的图片');
         if(a==1){
          return false;
         }
        }
        if(a==1){
         return true;
        }
    }
 }