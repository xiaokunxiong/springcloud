package com.chinasofti.springcloud.mail.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.chinasoft.springcloud.mail.domains.MailDomain;
import com.chinasoft.springcloud.order.events.OrderCancelEvent;
import com.chinasoft.springcloud.order.events.OrderCreateEvent;
import com.chinasoft.springcloud.order.stream.OrderChannel;
import com.chinasofti.springcloud.mail.db.MailRepository;

// 订阅order相关的事件
@Component
public class OrderEventListener {
	static final Logger logger = LoggerFactory.getLogger(OrderEventListener.class);

	@Autowired
	MailRepository mailRepository;

	@StreamListener(target = OrderChannel.CHANNEL, condition = "headers['event-type']=='OrderCreateEvent'")
	public void receive(OrderCreateEvent orderCreateEvent) {
		MailDomain mailDomain = new MailDomain();
		mailDomain.setSendTo(orderCreateEvent.getOrderDomain().getEmail());
		mailDomain.setSubject("新订单提醒");
		mailDomain.setContent("你有一个新的订单，订单号为：" + orderCreateEvent.getOrderDomain().getOrderId());
		mailRepository.save(mailDomain);
		logger.debug("发了一封新订单邮件");
	}

	@StreamListener(target = OrderChannel.CHANNEL, condition = "headers['event-type']=='OrderCancelEvent'")
	public void receive(OrderCancelEvent orderCancelEvent) {
		MailDomain mailDomain = new MailDomain();
		mailDomain.setSendTo(orderCancelEvent.getOrderDomain().getEmail());
		mailDomain.setSubject("取消订单提醒");
		mailDomain.setContent("订单取消成功，订单号为：" + orderCancelEvent.getOrderDomain().getOrderId());
		mailRepository.save(mailDomain);
		logger.debug("发了一封取消订单的邮件");
	}
}
