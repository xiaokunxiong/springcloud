package com.chinasoft.springcloud.order.events;

import com.chinasoft.springcloud.order.domains.OrderDomain;

// 订单取消事件
public class OrderCancelEvent {

	public OrderDomain orderDomain;

	public OrderDomain getOrderDomain() {
		return orderDomain;
	}

	public void setOrderDomain(OrderDomain orderDomain) {
		this.orderDomain = orderDomain;
	}

	public OrderCancelEvent() {
	}

	public OrderCancelEvent(OrderDomain orderDomain) {
		super();
		this.orderDomain = orderDomain;
	}

}
