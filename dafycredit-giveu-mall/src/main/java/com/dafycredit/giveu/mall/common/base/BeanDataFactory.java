package com.dafycredit.giveu.mall.common.base;

import com.dafycredit.giveu.mall.admin.dal.cache.redis.RedisCache;
import com.dafycredit.giveu.mall.admin.dal.entity.SystemAdmin;
import com.dafycredit.giveu.mall.admin.service.ISystemAdminService;


public class BeanDataFactory {

    private static ISystemAdminService systemAdminService;

    private static RedisCache redisCache;

    public static ISystemAdminService getSystemAdminService() {
       if (systemAdminService == null)
          systemAdminService = SpringContextHolder.getBean(ISystemAdminService.class);
        return systemAdminService;
    }


    public static RedisCache getRedisCache() {
        if (redisCache == null)
            redisCache = SpringContextHolder.getBean(RedisCache.class);
        return redisCache;
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
