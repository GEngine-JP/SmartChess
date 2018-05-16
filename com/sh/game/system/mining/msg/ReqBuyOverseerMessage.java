package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求购买监工</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBuyOverseerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBuyOverseerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48006;
	}
	
	/**
	 * 监工id
	 */
	private int overseerId;

	public int getOverseerId() {
		return overseerId;
	}

	public void setOverseerId(int overseerId) {
		this.overseerId = overseerId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.overseerId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, overseerId, false);
		return true;
	}
}
