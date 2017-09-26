package com.chinasoft.springcloud.order.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class OrderDomain implements Serializable {
	private static final long serialVersionUID = -2485043500570220853L;

	@Id
	@Column(name = "order_id")
	private String orderId; // 订单号

	@Column
	private String phone; // 手机号

	@Column
	private String email; // 邮箱

	@Column(name = "goods_id")
	private Long goodsId; // 商品ID

	@Column(name = "create_time")
	private Date createTime; // 创建时间

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
