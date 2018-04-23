package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>抢红包</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRobRedPackMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobRedPackMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23037;
	}
	
	/**
	 * 红包id
	 */
	private long redPackId;

	public long getRedPackId() {
		return redPackId;
	}

	public void setRedPackId(long redPackId) {
		this.redPackId = redPackId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.redPackId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, redPackId);
		return true;
	}
}
