package com.chinasoft.springcloud.mail.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_mail")
public class MailDomain implements Serializable {
	private static final long serialVersionUID = -2485043500570220853L;

	@Id
	@GeneratedValue
	@Column(name = "mail_id")
	private Long mailId;

	@Column(name = "send_to")
	private String sendTo;
	@Column
	private String subject;

	@Column
	private String content;

	public Long getMailId() {
		return mailId;
	}

	public void setMailId(Long mailId) {
		this.mailId = mailId;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
