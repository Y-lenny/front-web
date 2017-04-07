package com.hawk.springboot.base;

import com.hawk.springboot.dal.cache.redis.RedisCache;
import com.hawk.springboot.dal.entity.SystemAdmin;
import com.hawk.springboot.service.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yannfeng on 2016/9/29.
 */
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
