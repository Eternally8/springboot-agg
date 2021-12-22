package com.robben.redisExtend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class JedisCompent {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;


//    public Jedis getJedis(){
//        Jedis jedis = ((JedisConnection)jedisConnectionFactory.get()).getJedis();
//        return jedis;
//    }


}
