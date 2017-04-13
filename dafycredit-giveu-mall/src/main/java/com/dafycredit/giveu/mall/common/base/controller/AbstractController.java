package com.dafycredit.giveu.mall.common.base.controller;

import com.dafycredit.giveu.mall.common.exception.CustomerException;
import com.dafycredit.giveu.mall.common.util.ReponseMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AbstractController {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public JsonResult handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
		String code = ReponseMsg.SERVICE_FAILE.getCode();
		String msg = ReponseMsg.SERVICE_FAILE.getMsg();
		if (e instanceof IllegalArgumentException) {
			msg = ((IllegalArgumentException) e).getMessage();
		} else if (e instanceof CustomerException) {
			CustomerException e1 = (CustomerException) e;
			code = e1.getCode();
			msg = e1.getMsg();
		}
		e.printStackTrace();
		return new JsonResult(code, msg, null);
	}

	   // 组装 自定义错误
    public JsonResult serviceFail(ReponseMsg  reponseMsg) {
        if (reponseMsg == null) {
            reponseMsg = ReponseMsg.SERVER_ERROR;
        }
        return new JsonResult(reponseMsg.getCode(), reponseMsg.getMsg());
    }
	
	/**
	 * 服务执行成功
	 * 
	 * @param data
	 * @return
	 */
	public JsonResult serviceSuccess(Object data) {
		String code = ReponseMsg.SERVICE_SUCCESS.getCode();
		String msg = ReponseMsg.SERVICE_SUCCESS.getMsg();
		return new JsonResult(code, msg, data);
	}

	public class JsonResult {
		private String code;
		private String msg;
		private Object data;

		public JsonResult(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public JsonResult(String retCode, String retMsg, Object data) {
			this.code = retCode;
			this.msg = retMsg;
			this.data = data;
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

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}
	}
}
