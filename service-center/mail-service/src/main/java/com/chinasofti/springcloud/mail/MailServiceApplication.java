package com.chinasofti.springcloud.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.chinasoft.springcloud.order.stream.OrderInputChannel;

// 邮件系统
// 监听各个系统的事件，发送不同的邮件
@SpringBootApplication
@ComponentScan("com.dongnaoedu")
@EnableBinding({ OrderInputChannel.class }) // 通过stream绑定MQ
@EnableEurekaClient
public class MailServiceApplication {
	final static Logger logger = LoggerFactory.getLogger(MailServiceApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MailServiceApplication.class)
				.web(true).run(args);
		logger.debug(applicationContext.getId() + "已经启动,当前host：{}",
				applicationContext.getEnvironment().getProperty("HOSTNAME"));
	}
}
