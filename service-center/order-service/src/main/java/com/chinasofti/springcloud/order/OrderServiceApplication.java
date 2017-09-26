package com.chinasofti.springcloud.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.chinasoft.springcloud.order.stream.OrderOutputChannel;
import com.chinasoft.springcloud.sms.stream.SmsOutputChannel;

// 订单服务
@SpringBootApplication
@ComponentScan("com.dongnaoedu")
@EnableEurekaClient	
@EnableCircuitBreaker // hystrix熔断
@EnableFeignClients // feign
@EnableTransactionManagement // 事务
@EnableJpaRepositories(basePackages = { "com.dongnaoedu.springcloud" })
@EnableBinding({ OrderOutputChannel.class, SmsOutputChannel.class }) // 通过stream绑定MQ
public class OrderServiceApplication {
	final static Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(OrderServiceApplication.class)
				.web(true).run(args);
		logger.debug(applicationContext.getId() + "已经启动,当前host：{}",
				applicationContext.getEnvironment().getProperty("HOSTNAME"));
	}
}
