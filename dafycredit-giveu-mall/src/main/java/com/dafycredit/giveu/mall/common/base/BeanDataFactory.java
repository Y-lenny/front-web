package com.dafycredit.giveu.mall.common.base;

import com.dafycredit.giveu.mall.admin.dal.entity.SystemAdmin;
import com.dafycredit.giveu.mall.admin.service.ISystemAdminService;
import com.dafycredit.giveu.mall.common.base.controller.SpringContextHolder;


public class BeanDataFactory {

    private static ISystemAdminService systemAdminService;

    public static ISystemAdminService getSystemAdminService() {
       if (systemAdminService == null)
          systemAdminService = SpringContextHolder.getBean(ISystemAdminService.class);
        return systemAdminService;
    }

    public static SystemAdmin getAdminById(Integer id) {
        //TODO 设计从cache中获取
      //  String key = "adminObject_" + id;
      //  SystemAdmin admin = (SystemAdmin) getRedisCache().get(key);

      //  if(admin == null) {
        SystemAdmin  admin = getSystemAdminService().getSystemAdminById(id);

          //  getRedisCache().put(key, admin);
      //  }

        return admin;
    }
}
