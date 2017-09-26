package com.chinasoft.springcloud.order.events;

import com.chinasoft.springcloud.order.domains.OrderDomain;

// 订单创建事件
public class OrderCreateEvent {
	public OrderDomain orderDomain;

	public OrderDomain getOrderDomain() {
		return orderDomain;
	}

	public void setOrderDomain(OrderDomain orderDomain) {
		this.orderDomain = orderDomain;
	}
	
	public OrderCreateEvent() {
	}

	public OrderCreateEvent(OrderDomain orderDomain) {
		super();
		this.orderDomain = orderDomain;
	}

}
