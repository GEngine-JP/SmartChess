package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回设置Boss提醒</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSetBossRemindMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSetBossRemindMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30006;
	}
	
	/**
	 * 副本id
	 */
	private int instanceId;

	/**
	 * 状态 0未勾选 1勾选 
	 */
	private int state;


	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.instanceId = readInt(buf, false);
		this.state = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, state, false);

		return true;
	}
}

