package com.chinasoft.springcloud.sms.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface SmsOutputChannel {
	@Output(SmsChannel.CHANNEL)
	MessageChannel output(); // 这里的channel是用来发送数据的
}
