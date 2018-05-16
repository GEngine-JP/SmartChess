package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求购买矿工</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBuyMinerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBuyMinerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48004;
	}
	
	/**
	 * 矿工id
	 */
	private int minerId;

	public int getMinerId() {
		return minerId;
	}

	public void setMinerId(int minerId) {
		this.minerId = minerId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.minerId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, minerId, false);
		return true;
	}
}
