package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>查看红包详情</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRedPackDetailMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRedPackDetailMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23041;
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
