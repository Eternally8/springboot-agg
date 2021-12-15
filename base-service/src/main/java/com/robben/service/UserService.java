package com.robben.service;

import com.robben.dao.UserDao;
import com.robben.model.UserVoEntity;
import com.robben.utils.SpringBeanTools;
import com.robben.utils.StartRunFrist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@EnableCaching
public class UserService {

    private UserService userService2;

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init(){
        //此方法调用不了
        userService2 = SpringBeanTools.getBean("userService");
    }


    public void insertUser(UserVoEntity vo) {
         userDao.insertUser(vo);
    }

    public UserVoEntity getUserById(int id) {
        return userDao.getUserById(id);
    }

    public int updateUser(UserVoEntity vo) {
        return userDao.updateUser(vo);
    }

    public int delUserById(int id) {
        return userDao.delUserById(id);
    }

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
        log.info("~~~~~~~~hanlde-DB~~~~~~~~~~~~~~");
        return userDao.getUserById(id);
    }

    @Cacheable(value = "UserService_getUserByRedisTimeObject#s#100",key = "#p0.id +'::'+#p0.name")
    public UserVoEntity getUserByRedisTimeObject(UserVoEntity vo) {
        log.info("~~~~~~~~hanlde-DB~~~~~~~~~~~~~~");
        return vo;
    }

    public void postConstructTest() {
        userService2.getUserByRedis(1);
    }




}
