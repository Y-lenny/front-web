package com.dafycredit.giveu.mall.admin.dal.entity;

import java.util.Date;
import java.util.List;

public class SystemRole {

	private Integer id;

	private String name;

	private List<SystemModule> modules;

	private String appId;   //appId
	
	private String remark;

	/**表记录状态：enable：可用，disable：不可用，delete：逻辑删除**/
	private String  status;
	private Date createTime;     //创建时间
	private Integer createUserId; //创建人
	private Date updateTime;
	private Integer updateUserId;  //更新人

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public List<SystemModule> getModules() {
		return modules;
	}

	public void setModules(List<SystemModule> modules) {
		this.modules = modules;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
}
