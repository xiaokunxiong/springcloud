package com.chinasoft.springcloud.order.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface OrderInputChannel {
	@Input(OrderChannel.CHANNEL)
	SubscribableChannel input(); // 注意看，这里的channel是用来接收数据的
}
