package com.chinasofti.springcloud.order;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasoft.springcloud.order.domains.OrderDomain;
import com.chinasofti.springcloud.order.db.OrderRepository;

// 订单服务
@RestController
@RequestMapping("/order")
public class OrderController {
	static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@RequestMapping("/new/{goodsId}")
	public String add(@PathVariable("goodsId") long goodsId, @RequestHeader(name = "phone") String phone,
			@RequestHeader(name = "email") String email) throws Exception {
		// 新增订单
		OrderDomain order = new OrderDomain();
		order.setOrderId(UUID.randomUUID().toString());
		order.setCreateTime(new Date());
		order.setEmail(email);
		order.setPhone(phone);
		order.setGoodsId(goodsId);
		orderService.save(order);

		return "end";
	}

	// 取消订单
	// 这里没做校验
	@RequestMapping("/cancel/{orderId}")
	public String cancel(@PathVariable("orderId") String orderId) throws Exception {
		orderService.delete(orderId);
		return "end";
	}

	// 根据手机号码查订单
	@RequestMapping("/orders")
	public List<OrderDomain> orders(@RequestHeader(name = "phone") String phone) {
		return orderRepository.findByPhone(phone);
	}
}
