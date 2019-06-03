package com.customer.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon负载均衡
 * 规则实现需继承IRule或AbstractLoadBalancerRule或PredicateBasedRule
 * 具体实现可参考已有规则：RandomRule、RoundRobinRule、ZoneAvoidanceRule
 */
@Configuration
@RibbonClients(value = {@RibbonClient(value = "getAdmin")}, defaultConfiguration = RibbonConfiguration.class)
//@RibbonClient(name = "microservice-privoder", configuration = RibbonConfiguration.class)
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
