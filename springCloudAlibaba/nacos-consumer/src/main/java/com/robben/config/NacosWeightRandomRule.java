package com.robben.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description： TODO
 * Author: robben
 * Date: 2020/12/15 16:25
 * Nacos权重配置对Spring Cloud Alibaba无效。也就是说，不管在Nacos控制台上如何配置，调用时都不管权重设置的。
 * Spring Cloud Alibaba通过整合Ribbon的方式，实现了负载均衡。
 * 如何扩展Ribbon，让其支持Nacos的权重配置，三种方案
 * https://cloud.tencent.com/developer/article/1460975
 */
@Slf4j
public class NacosWeightRandomRule extends AbstractLoadBalancerRule {
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Autowired
    private NacosServiceManager nacosServiceManager;


    @Override
    public Server choose(Object key) {
        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) getLoadBalancer();
        // 请求的微服务名称
        String applicationName = loadBalancer.getName();
        try {
            // nacos 通过基于权重的负载均衡算法，算出一个健康的服务实例以供调用
            NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
            Instance instance = namingService.selectOneHealthyInstance(applicationName);
//            Instance instance2 = nacosDiscoveryProperties.namingServiceInstance().selectOneHealthyInstance(applicationName);
            log.info("获取的服务示例为:{}", instance.getPort());
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("获取服务实例异常：{}", e.getMessage());
        }
        return null;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}