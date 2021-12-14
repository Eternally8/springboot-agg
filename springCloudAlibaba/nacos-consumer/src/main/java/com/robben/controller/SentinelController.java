package com.robben.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.robben.model.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "sentinel使用示例")
@RestController
@RequestMapping("/limitReq")
public class SentinelController {

    @ApiOperation(value = "原始方式使用限流")
    @GetMapping("/hello")
    public String hello() {
        try (Entry entry = SphU.entry("Hello")) {
            return "Hello Sentinel";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "系统繁忙，请稍后";
    }

    /**
     * 定义限流规则
     *
     * @PostConstruct 此注解的含义是：本类构造方法执行结束后执行
     */

    @PostConstruct
    public void init() {
        //1.创建存放限流规则的集合
        List<FlowRule> rules = new ArrayList<>();
        //2.创建限流规则
        FlowRule rule = new FlowRule();
        //定义资源，表示Sentinel会对哪个资源生效
        rule.setResource("Hello");
        //定义限流的类型(此处使用QPS作为限流类型)
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //定义QPS每秒通过的请求数
        rule.setCount(1);

        FlowRule rule2 = new FlowRule();
        rule2.setResource("getStu2");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);

        //3.将限流规则存放到集合中
        rules.add(rule);
        rules.add(rule2);
        //4.加载限流规则
        FlowRuleManager.loadRules(rules);
    }


    @ApiOperation(value = "注解使用限流")
    @SentinelResource(value = "getStu", blockHandler = "blockHandlerForGetUser")
    @GetMapping(value = "/getStu")
    public StudentVo getStu() {
        log.info("调用获取资源");
        StudentVo vo = new StudentVo();
        vo.setAge(1);
        vo.setName("获取到一个限流资源");
        vo.setId(1);

        return vo;
    }

    // blockHandler 函数，原方法调用被限流/降级/系统保护的时候调用
    public StudentVo blockHandlerForGetUser(BlockException ex) {
        StudentVo v = new StudentVo();
        v.setAge(0);
        v.setName("没有访问到具体资源");
        v.setId(0);
        return v;
    }


    @ApiOperation(value = "springCloud使用限流")
    @SentinelResource(value = "getStu2", blockHandler = "getStu2ExceptionHandler")
    @GetMapping(value = "/getStu2")
    public String getStu2() {
        return "lalalalala";
    }


    public String getStu2ExceptionHandler(BlockException e) {
        e.printStackTrace();
        return "系统繁忙请稍后再试";
    }


}
