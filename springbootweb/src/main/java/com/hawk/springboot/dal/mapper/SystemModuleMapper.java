package com.hawk.springboot.dal.mapper;

import com.hawk.springboot.dal.entity.SystemModule;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yannfeng on 2016/11/9.
 */
@Mapper
public interface SystemModuleMapper extends BaseMapper<SystemModule> {

    int deleteSysRoleModuleByModuleId(Integer moduleId);

}
