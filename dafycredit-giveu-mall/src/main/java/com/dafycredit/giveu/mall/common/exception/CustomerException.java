package com.dafycredit.giveu.mall.common.exception;

public class CustomerException extends Exception {
	private static final long serialVersionUID = -8409537341192590238L;
	// 异常代码
	private String code;
	// 异常消息体
	private String msg;

	public CustomerException(String code, String msg) {
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

}
