package com.dafycredit.giveu.mall.admin.dal.mapper;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemRoleModule;
import com.dafycredit.giveu.mall.admin.dal.entity.SystemRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    List<SystemRole> queryAllSystemRoleModules();

    SystemRole getSystemRoleModulesById(Integer id);

    int insertSystemRoleModule(SystemRoleModule roleModule);

    int insertSystemRoleModuleBatch(@Param("roleModules")List<SystemRoleModule> roleModules);

    int deleteSystemRoleModuleByRoleId(Integer roleId);
    
}
