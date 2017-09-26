package com.chinasofti.springcloud.wms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wms")
public class WmsController {

	@Autowired
	GoodsService goodsService;

	// 锁定库存
	@PostMapping("/lock/{goodsId}")
	public String lock(@PathVariable("goodsId") long goodsId) {
		goodsService.lock(goodsId);
		return "ok";
	}

	// 释放库存
	@PostMapping("/release/{goodsId}")
	public String release(@PathVariable("goodsId") long goodsId) {
		goodsService.release(goodsId);
		return "ok";
	}
}