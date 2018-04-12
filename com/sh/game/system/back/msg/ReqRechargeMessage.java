package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>充值</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRechargeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRechargeMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43019;
	}
	
	/**
	 * 玩家登录账号
	 */
	private String loginName;

	/**
	 * 元宝数量
	 */
	private int count;

	/**
	 * sid
	 */
	private int sid;

	/**
	 * 平台订单号
	 */
	private String order_sn;

	/**
	 * 自有订单号
	 */
	private long order_id;

	/**
	 * 商品id
	 */
	private int goodsId;

	/**
	 * 0、充值元宝 1、绑定元宝
	 */
	private int type;

	/**
	 * 平台的商品id
	 */
	private String productId;

	/**
	 * 渠道id
	 */
	private int qudao;


	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	
	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	
	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	public int getQudao() {
		return qudao;
	}

	public void setQudao(int qudao) {
		this.qudao = qudao;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.loginName = readString(buf);
		this.count = readInt(buf, false);
		this.sid = readInt(buf, false);
		this.order_sn = readString(buf);
		this.order_id = readLong(buf);
		this.goodsId = readInt(buf, false);
		this.type = readInt(buf, false);
		this.productId = readString(buf);
		this.qudao = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, loginName);
		this.writeInt(buf, count, false);
		this.writeInt(buf, sid, false);
		this.writeString(buf, order_sn);
		this.writeLong(buf, order_id);
		this.writeInt(buf, goodsId, false);
		this.writeInt(buf, type, false);
		this.writeString(buf, productId);
		this.writeInt(buf, qudao, false);

		return true;
	}
}

