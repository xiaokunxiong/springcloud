package com.chinasofti.springcloud.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.chinasoft.springcloud.wms.domains.GoodsDomain;
import com.chinasofti.springcloud.wms.db.GoodsRepository;

@Component
public class GoodsService {
	static final Logger logger = LoggerFactory.getLogger(GoodsService.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	GoodsRepository goodsRepository;

	public void lock(long goodsId) {
		int c = 0;
		// 乐观锁，如果版本不一致，则再次获取
		while (c == 0) {
			GoodsDomain goodsDomain = goodsRepository.findOne(goodsId);
			c = jdbcTemplate.update("update tb_goods set stock_count = stock_count - 1 where goods_id=" + goodsId
					+ " and version=" + goodsDomain.getVersion());
		}

		logger.debug("锁定商品，编号为：{}，库存-1", goodsId);
	}

	public void release(long goodsId) {
		int c = 0;
		// 乐观锁，如果版本不一致，则再次获取
		// update <table> set xx=xx where version = <version>
		while (c == 0) {
			GoodsDomain goodsDomain = goodsRepository.findOne(goodsId);
			c = jdbcTemplate.update("update tb_goods set stock_count = stock_count + 1 where goods_id=" + goodsId
					+ " and version=" + goodsDomain.getVersion());
		}

		logger.debug("释放库存锁定，商品编号为：{},，库存+1", goodsId);
	}

}
