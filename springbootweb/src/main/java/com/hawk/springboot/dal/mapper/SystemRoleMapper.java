package com.hawk.springboot.dal.mapper;

import com.hawk.springboot.common.PageBean;
import com.hawk.springboot.dal.entity.SystemModule;
import com.hawk.springboot.dal.entity.SystemRole;
import com.hawk.springboot.dal.entity.SystemRoleModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yannfeng on 2016/11/9.
 */
@Mapper
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    List<SystemRole> queryAllSystemRoleModules();

    SystemRole getSystemRoleModulesById(Integer id);

    int insertSystemRoleModule(SystemRoleModule roleModule);

    int insertSystemRoleModuleBatch(@Param("roleModules")List<SystemRoleModule> roleModules);

    int deleteSystemRoleModuleByRoleId(Integer roleId);
    
}
