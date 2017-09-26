package com.chinasofti.springcloud.mail.db;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.chinasoft.springcloud.mail.domains.MailDomain;

public interface MailRepository extends PagingAndSortingRepository<MailDomain, Long> {
}