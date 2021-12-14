//package com.robben.controller;
//
//import com.robben.config.WebSocketComponent;
//import com.robben.service.OtherService;
//import com.robben.utils.Contants;
//import com.robben.utils.MyBeanMap;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.io.IOException;
//
//@Slf4j
//@Api(tags = "其他方法测试")
//@RestController
//@RequestMapping("/otherController")
//public class OtherController {
//    @Autowired
//    private OtherService otherService;
//
//    @ApiOperation(value = "测试接口连通性")
//    @GetMapping("testApi")
//    public String testApi() {
//       log.info("1");
//       return "suceess";
//    }
//
//    @ApiOperation(value = "websocket消息推送")
//    @PostMapping("sendWebscoketMsg")
//    public String sendWebscoketMsg(String msg) throws IOException {
//        WebSocketComponent.sendInfo(msg,"1");
//        return "suceess";
//    }
//
//    @ApiOperation(value = "测试注解异步线程执行")
//    @GetMapping("test")
//    public String test() {
//        /**
//         * 设置主线程的requset可以给子线程是使用
//         */
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        RequestContextHolder.setRequestAttributes(servletRequestAttributes,true);
//
//        ThreadPoolTaskExecutor th = MyBeanMap.getBean(Contants.MY_EXECUTOR);
//        for (int i=0;i<10;i++) {
//            th.execute(() -> {
//               log.info(otherService.getTime());
//            });
//        }
//
//        otherService.getThreadName();
//        otherService.getThreadName2();
//        return "suceess";
//    }
//
//
//
//}
