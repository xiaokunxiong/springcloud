package com.chinasofti.springcloud.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// 仓储服务
@SpringBootApplication
@ComponentScan("com.dongnaoedu")
@EnableEurekaClient
@EnableCircuitBreaker
public class WmsServiceApplication {
	final static Logger logger = LoggerFactory.getLogger(WmsServiceApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(WmsServiceApplication.class)
				.web(true).run(args);
		logger.debug(applicationContext.getId() + "已经启动,当前host：{}",
				applicationContext.getEnvironment().getProperty("HOSTNAME"));
	}
}
