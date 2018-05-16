package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求矿场抢夺</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRobMineMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobMineMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48010;
	}
	
	/**
	 * 目标id
	 */
	private long targetId;

	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.targetId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, targetId);
		return true;
	}
}
