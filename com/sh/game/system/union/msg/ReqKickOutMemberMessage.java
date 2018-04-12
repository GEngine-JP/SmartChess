package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求踢出玩家</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqKickOutMemberMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqKickOutMemberMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23007;
	}
	
	/**
	 * 选择的玩家ID
	 */
	private long memberId;


	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.memberId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, memberId);

		return true;
	}
}

