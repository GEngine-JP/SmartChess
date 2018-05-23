package com.sh.game.system.battle.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class RingTriggerDataBean extends KryoBean {

	/**
	 * 触发特戒类型
	 */
	private int type;
	/**
	 * 1为触发
	 */
	private int isTrigger;
	/**
	 * 触发到期时间（战报的持续时间）
	 */
	private int endTime;

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

		public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.isTrigger = readInt(buf, false);
		this.endTime = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, isTrigger, false);
		this.writeInt(buf, endTime, false);
		return true;
	}
}
