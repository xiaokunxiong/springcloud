package com.chinasofti.springcloud.wms.db;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.chinasoft.springcloud.wms.domains.GoodsDomain;

public interface GoodsRepository extends PagingAndSortingRepository<GoodsDomain, Long> {
}