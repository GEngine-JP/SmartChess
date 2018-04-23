package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>获取订单号</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOrderIdMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOrderIdMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44009;
	}
	
	/**
	 * goodsId
	 */
	private int goodsId;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.goodsId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, goodsId, false);
		return true;
	}
}
