package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送特戒触发信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRingTriggerInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRingTriggerInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25010;
	}
	
	/**
	 * 触发时触发者id
	 */
	private long triggerId;
	/**
	 * 触发特戒类型
	 */
	private int type;
	/**
	 * 1为触发
	 */
	private int isTrigger;

	public long getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(long triggerId) {
		this.triggerId = triggerId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getIsTrigger() {
		return isTrigger;
	}

	public void setIsTrigger(int isTrigger) {
		this.isTrigger = isTrigger;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.triggerId = readLong(buf);
		this.type = readInt(buf, false);
		this.isTrigger = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, triggerId);
		this.writeInt(buf, type, false);
		this.writeInt(buf, isTrigger, false);
		return true;
	}
}
