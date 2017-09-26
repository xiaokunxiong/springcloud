package com.chinasoft.springcloud.order.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderOutputChannel {
	@Output(OrderChannel.CHANNEL)
	MessageChannel output(); // 这里的channel是用来发送数据的
}
