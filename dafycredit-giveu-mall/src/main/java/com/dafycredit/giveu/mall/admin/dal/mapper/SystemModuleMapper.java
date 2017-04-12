package com.dafycredit.giveu.mall.admin.dal.mapper;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemModule;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SystemModuleMapper extends BaseMapper<SystemModule> {

    int deleteSysRoleModuleByModuleId(Integer moduleId);

}
