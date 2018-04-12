package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通知前端加特殊buff</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendRecycleBossSpecialState extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRecycleBossSpecialState() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30013;
	}
	
	/**
	 * 获得者id
	 */
	private long targetId;

	/**
	 * buff结束时间
	 */
	private int endTime;


	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	
	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetId = readLong(buf);
		this.endTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, targetId);
		this.writeInt(buf, endTime, false);

		return true;
	}
}

