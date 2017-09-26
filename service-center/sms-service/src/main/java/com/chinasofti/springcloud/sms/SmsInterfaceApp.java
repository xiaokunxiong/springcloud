package com.chinasofti.springcloud.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;

import com.chinasoft.springcloud.sms.stream.SmsInputChannel;

// 短信服务
// 可以调用接口发送短信，也可以通过MQ异步处理
@SpringBootApplication
@EnableEurekaClient
@EnableBinding({ SmsInputChannel.class }) // 增加一个stream通道
public class SmsInterfaceApp {

	final static Logger logger = LoggerFactory.getLogger(SmsInterfaceApp.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SmsInterfaceApp.class)
				.web(true).run(args);
		logger.debug(applicationContext.getId() + "已经启动,当前host：{}",
				applicationContext.getEnvironment().getProperty("HOSTNAME"));
	}
}
