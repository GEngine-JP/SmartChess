package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>申请入会状态变化</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResApplyForUnionStateChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResApplyForUnionStateChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23002;
	}
	
	/**
	 * 帮会申请状态
	 */
	private int state;

	/**
	 * 帮会id
	 */
	private long unionId;


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public long getUnionId() {
		return unionId;
	}

	public void setUnionId(long unionId) {
		this.unionId = unionId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.state = readInt(buf, false);
		this.unionId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, state, false);
		this.writeLong(buf, unionId);

		return true;
	}
}

