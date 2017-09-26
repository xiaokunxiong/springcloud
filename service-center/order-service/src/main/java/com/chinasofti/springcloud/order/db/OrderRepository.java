package com.chinasofti.springcloud.order.db;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.chinasoft.springcloud.order.domains.OrderDomain;

public interface OrderRepository extends PagingAndSortingRepository<OrderDomain, String> {
	// 根据手机号查找
	List<OrderDomain> findByPhone(String phone);
}