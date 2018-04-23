package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求弹劾会长</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqImpeachLeaderMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqImpeachLeaderMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23049;
	}
	
	/**
	 * 会长id
	 */
	private long leaderId;

	public long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(long leaderId) {
		this.leaderId = leaderId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.leaderId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, leaderId);
		return true;
	}
}
