package com.chinasofti.springcloud.sms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.chinasoft.springcloud.sms.domains.SmsDomain;
import com.chinasoft.springcloud.sms.stream.SmsChannel;
import com.chinasofti.springcloud.sms.db.SmsRepository;

// 通过stream对MQ的支持，实现异步处理
// 接收新消息
@Component
public class SmsMqListener {
	static final Logger logger = LoggerFactory.getLogger(SmsMqListener.class);

	@Autowired
	SmsRepository smsRepository;

	@StreamListener(SmsChannel.CHANNEL)
	public void receive(SmsDomain smsDomain) {
		smsRepository.save(smsDomain);
		logger.debug("给手机号{}发送一条新短信,短信内容:{}", smsDomain.getPhone(), smsDomain.getContent());
	}
}
