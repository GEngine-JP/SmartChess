package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送监工信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOverseerInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOverseerInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48007;
	}
	
	/**
	 * 当前生效的监工
	 */
	private int overseerId;
	/**
	 * 监工结束时间
	 */
	private int overTime;

	public int getOverseerId() {
		return overseerId;
	}

	public void setOverseerId(int overseerId) {
		this.overseerId = overseerId;
	}

		public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.overseerId = readInt(buf, false);
		this.overTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, overseerId, false);
		this.writeInt(buf, overTime, false);
		return true;
	}
}
