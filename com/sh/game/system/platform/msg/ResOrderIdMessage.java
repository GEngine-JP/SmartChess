package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回订单号</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOrderIdMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOrderIdMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44010;
	}
	
	/**
	 * goodsId
	 */
	private int goodsId;
	/**
	 * 订单号
	 */
	private String order_id;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

		public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.goodsId = readInt(buf, false);
		this.order_id = readString(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, goodsId, false);
		this.writeString(buf, order_id);
		return true;
	}
}
