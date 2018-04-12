package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送监工信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
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
		return 48008;
	}
	
	/**
	 * 监工结束时间
	 */
	private int overTime;


	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.overTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, overTime, false);

		return true;
	}
}

