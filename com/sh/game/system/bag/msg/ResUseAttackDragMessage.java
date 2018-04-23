package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>使用攻击药水的返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResUseAttackDragMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUseAttackDragMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10010;
	}
	
	/**
	 * 当前倍数
	 */
	private int rate;
	/**
	 * 副本id
	 */
	private int instanceId;
	/**
	 * 使用次数
	 */
	private int useCount;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

		public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rate = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.useCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rate, false);
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, useCount, false);
		return true;
	}
}
