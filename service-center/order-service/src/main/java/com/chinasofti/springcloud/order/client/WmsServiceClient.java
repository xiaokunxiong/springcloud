package com.chinasofti.springcloud.order.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.hystrix.FallbackFactory;

// 这是一个feign写的客户端，用于请求wms服务相关的接口
@FeignClient(name = "wms-service", path = "/wms", fallbackFactory = WmsFallbackFactory.class)
public interface WmsServiceClient {

	// 锁定库存
	@RequestMapping(value = "/lock/{goodsId}", method = RequestMethod.POST)
	public String lock(@PathVariable("goodsId") long goodsId);

	// 释放库存
	@RequestMapping(value = "/release/{goodsId}", method = RequestMethod.POST)
	public String release(@PathVariable("goodsId") long goodsId);

}

// 降级工厂
@Component
class WmsFallbackFactory implements FallbackFactory<WmsServiceClient> {
	static final Logger logger = LoggerFactory.getLogger(WmsFallbackFactory.class);

	@Autowired
	WmsServiceFallback wmsServiceFallback;

	@Override
	public WmsServiceClient create(Throwable cause) {
		if (wmsServiceFallback == null) {
			return new WmsServiceFallback();
		}
		
		logger.info("wms服务调用异常", cause);
		return wmsServiceFallback;
	}

}

// 降级需要调用的本地实现
@Component
class WmsServiceFallback implements WmsServiceClient {

	static final Logger logger = LoggerFactory.getLogger(WmsServiceFallback.class);

	@Override
	public String lock(long skuid) {
		logger.warn("降级：WmsService.lock异常");
		return null;
	}

	@Override
	public String release(long goodsId) {
		logger.warn("降级：WmsService.release异常");
		return null;
	}

}