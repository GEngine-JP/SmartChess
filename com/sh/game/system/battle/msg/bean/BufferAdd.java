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

public class BufferAdd extends KryoBean {

	/**
	 * buff的id
	 */
	private int bufferId;
	/**
	 * 移除时间
	 */
	private int totalTime;

	public int getBufferId() {
		return bufferId;
	}

	public void setBufferId(int bufferId) {
		this.bufferId = bufferId;
	}

		public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.bufferId = readInt(buf, false);
		this.totalTime = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, bufferId, false);
		this.writeInt(buf, totalTime, false);
		return true;
	}
}
