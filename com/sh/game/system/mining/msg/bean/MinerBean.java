package com.sh.game.system.mining.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class MinerBean extends KryoBean {

	/**
	 * 矿工id
	 */
	private int minerId;
	/**
	 * 矿工类型
	 */
	private int minerType;
	/**
	 * 收获时间
	 */
	private int gainTime;

	public int getMinerId() {
		return minerId;
	}

	public void setMinerId(int minerId) {
		this.minerId = minerId;
	}

		public int getMinerType() {
		return minerType;
	}

	public void setMinerType(int minerType) {
		this.minerType = minerType;
	}

		public int getGainTime() {
		return gainTime;
	}

	public void setGainTime(int gainTime) {
		this.gainTime = gainTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.minerId = readInt(buf, false);
		this.minerType = readInt(buf, false);
		this.gainTime = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, minerId, false);
		this.writeInt(buf, minerType, false);
		this.writeInt(buf, gainTime, false);
		return true;
	}
}
