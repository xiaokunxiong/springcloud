package com.chinasofti.springcloud.sms.db;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.chinasoft.springcloud.sms.domains.SmsDomain;

public interface SmsRepository extends PagingAndSortingRepository<SmsDomain, Long> {
}