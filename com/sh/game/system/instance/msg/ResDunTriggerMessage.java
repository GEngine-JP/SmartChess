package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>护盾触发消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDunTriggerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDunTriggerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20032;
	}
	
	/**
	 * 触发次数
	 */
	private int triggerCount;

	public int getTriggerCount() {
		return triggerCount;
	}

	public void setTriggerCount(int triggerCount) {
		this.triggerCount = triggerCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.triggerCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, triggerCount, false);
		return true;
	}
}
