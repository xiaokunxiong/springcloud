package com.chinasoft.springcloud.sms.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SmsInputChannel {
	@Input(SmsChannel.CHANNEL)	
	SubscribableChannel input(); // 注意看，这里的channel是用来接收数据的
}
