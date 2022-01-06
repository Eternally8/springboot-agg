package com.robben.service;

import com.robben.dao.UserDao;
import com.robben.model.UserVoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableCaching
public class CacheService {

    @Autowired
    private UserDao userDao;


    @Cacheable(value = "UserService_getUserByRedisTime#s#100")
    public UserVoEntity getUserByRedisTime(int id) {
        return userDao.getUserById(id);
    }

    @Cacheable(value = "UserService_getUserByRedisValue")
    public UserVoEntity getUserByRedisValue(int id) {
        return userDao.getUserById(id);
    }

    //目前缓存必须带value
    @Cacheable(value = "test",keyGenerator = "cacheKeyGenerator")
    public UserVoEntity getUserByRedis(int id) {
        log.info("~~~~~~~~handle-DB~~~~~~~~~~~~~~");
        return userDao.getUserById(id);
    }

    @Cacheable(value = "UserService_getUserByRedisTimeObject#s#100",key = "#p0.id +'::'+#p0.name")
    public UserVoEntity getUserByRedisTimeObject(UserVoEntity vo) {
        log.info("~~~~~~~~handle-DB~~~~~~~~~~~~~~");
        return vo;
    }

}
