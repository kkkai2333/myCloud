package com.customer.demo.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 代码配置时，可配置项
 *
 * Decoder feignDecoder: ResponseEntityDecoder (which wraps a SpringDecoder)
 * Encoder feignEncoder: SpringEncoder
 * Logger feignLogger: Slf4jLogger
 * Contract feignContract: SpringMvcContract
 * Feign.Builder feignBuilder: HystrixFeign.Builder
 * Client feignClient: if Ribbon is enabled it is a LoadBalancerFeignClient, otherwise the default feign client is used.
 *
 * Logger.Level
 * Retryer
 * ErrorDecoder
 * Request.Options
 * Collection<RequestInterceptor>
 * SetterFactory
 */
@Configuration
public class ProviderFeignConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

}
