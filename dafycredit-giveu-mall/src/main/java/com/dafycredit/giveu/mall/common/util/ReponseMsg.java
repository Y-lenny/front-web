package com.dafycredit.giveu.mall.common.util;

public enum ReponseMsg {

	SERVER_ERROR("500", "服务器忙，请稍后再试"),

	SERVICE_FAILE("600", "服务执行失败"),

	SERVICE_SUCCESS("0", "success"),

	DECOMPRESS_ERROR("60001", "GZipUtils.decompress is Exception !!!"),

	REQUEST_IS_NULL("60002", "request  is null !!!"),

	FILE_UPLOAD_FAILED("0070010", "File upload failed ."),
	FARSE_APK_FAILED("0070020","parse apk was failed ."),
	FARSE_I18N_FAILED("0070030","parse i18n was failed ."), ;


	private String code;
	private String msg;

	ReponseMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static String getMsg(String code) {
		for (ReponseMsg c : ReponseMsg.values()) {
			if (c.getCode().equals(code)) {
				return c.getMsg();
			}
		}
		return null;
	}

}
