package com.robben.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description： TODO
 * Author: robben
 * Date: 2020/12/14 20:43
 */
@Configuration
public class BalanceConfig {
//    /**
//     * 默认按顺序轮询
//     * @return
//     */
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }


    /*
        配置类 将IRule 的实现类注册到spring容器中即可
        上述的本地负载均衡都是Robin的默认轮训策略，以下列举Robin负载均衡实现类：
        RoundRobinRule 轮询
        RandomRule 随机
        AvailabilityFilteringRule 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数超过阈值的服务，然后对剩余的服务列表进行轮询
        WeightedResponseTimeRule 权重 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
        RetryRule 重试 先按照轮询策略获取服务，如果获取失败则在指定时间内重试，获取可用服务
        BestAvailableRule 选过滤掉多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        ZoneAvoidanceRule 符合判断server所在区域的性能和server的可用性选择服
     */
    @Bean
    public IRule myRule() {
//         return new RoundRobinRule();//轮询
        // return new RetryRule();//重试
        // return new BestAvailableRule();
        // return new WeightedResponseTimeRule();// 权重
        return new NacosWeightRandomRule();  //自定义权重比例
    }


}