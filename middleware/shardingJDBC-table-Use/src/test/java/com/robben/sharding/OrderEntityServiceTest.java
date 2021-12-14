package com.robben.sharding;

/**
 * Description： TODO
 * Author: robben
 * Date: 2021/11/16 17:49
 */
import com.alibaba.fastjson.JSON;
import com.robben.sharding.dao.UserDao;
import com.robben.sharding.entity.OrderEntity;
import com.robben.sharding.dao.OrderMapper;
import com.robben.sharding.entity.UserVoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityServiceTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderMapper orderMapper;


    @Test
    public void createTable() {
        try {
            orderMapper.createTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUser() {
        UserVoEntity userById = userDao.getUserById(6);
        System.out.println("order = " + JSON.toJSONString(userById));
    }


    @Test
    public void insertOrder() {
        final Date saveTime = new Date();
        final long saveTimeCom = saveTime.getTime();
        System.out.println("当前时间的毫秒是：" + saveTimeCom);
        final OrderEntity orderEntity = new OrderEntity(1, 2, 3, 4, 5, saveTime, saveTimeCom);
        orderMapper.insert(orderEntity);
    }


    @Test
    public void insertBatch() throws InterruptedException {
        final ArrayList<OrderEntity> orderEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Date saveTime = new Date();
            final long saveTimeCom = saveTime.getTime();
            System.out.println("saveTimeCom = " + saveTimeCom);
            final OrderEntity orderEntity = new OrderEntity(1, 2, 3, 4, 5, saveTime, saveTimeCom);
            orderEntities.add(orderEntity);
            Thread.sleep(100);
        }
        orderMapper.insertBatch(orderEntities);
    }

    @Test
    public void insertBatch2() {

        // 采用随机时间进行测试，时间区间为2020-01-01到2121-12-31，经转换，2020开始毫秒为：1577808000000，2021结束毫秒为：1640966399000
        final ThreadLocalRandom current = ThreadLocalRandom.current();

        final ArrayList<OrderEntity> orderEntities = new ArrayList<>();
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            final long randomTime = current.nextLong(1577808000000L, 1640966399000L);
            final Date saveTime = new Date(randomTime);
            System.out.println("随机生成的时间为：" + format.format(saveTime) + "毫秒为：" + randomTime);

            final OrderEntity orderEntity = new OrderEntity(1, 2, 3, 4, 5, saveTime, randomTime);
            orderEntities.add(orderEntity);
        }
        orderMapper.insertBatch(orderEntities);
    }

    @Test
    public void fingOrderById() {
        final OrderEntity orderEntity = orderMapper.findById(667461387974344705l);
        System.out.println("order = " + orderEntity);
    }


    @Test
    public void findOrderBySaveTimeCom() {
        final OrderEntity orderEntity = orderMapper.findBySaveTimeCom(1637064795128l);
        System.out.println("order = " + orderEntity);
    }


    @Test
    public void findByOrderBytemporalInterval() {
        // 单库单表
//        List<Order> orderEntities = orderMapper.findByOrderBytemporalInterval(1609713297565L, 1611479203727L);
//        orderEntities.forEach(order -> System.out.println("order = " + order));

        // 跨库范围查询
        List<OrderEntity> orderEntities = orderMapper.findByOrderBytemporalInterval(1637064795120l, 1637065241639l);
        orderEntities.forEach(order -> System.out.println("order = " + order));
    }


}
