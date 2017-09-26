package com.chinasoft.springcloud.sms.stream;

import org.springframework.stereotype.Component;

@Component
public interface SmsChannel extends SmsInputChannel, SmsOutputChannel {
	String CHANNEL = "sms-send";
}
