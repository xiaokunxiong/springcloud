package com.chinasoft.springcloud.sms.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sms")
public class SmsDomain implements Serializable {
	private static final long serialVersionUID = -2485043500570220853L;

	@Id
	@GeneratedValue
	private Long smsId;

	@Column
	private String phone;
	@Column
	private String content;

	public Long getSmsId() {
		return smsId;
	}

	public void setSmsId(Long smsId) {
		this.smsId = smsId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
