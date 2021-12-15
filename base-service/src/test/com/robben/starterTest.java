package com.robben;

import com.robben.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description： TODO
 * Author: robben
 * Date: 2021/6/18 12:01
 */
@SpringBootTest
public class starterTest {

    @Autowired
    private UserService userService;

    //测试的话需要注释掉websocket相关的类,在config文件夹下
    @Test
    public void test1(){
        userService.postConstructTest();

        userService.postConstructTest();
    }


}
