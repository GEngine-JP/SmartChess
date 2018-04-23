package com.sh.game.system.qianghua.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class StrengthenBean extends KryoBean {

	/**
	 * 装备位置
	 */
	private int index;
	/**
	 * 强化配置id
	 */
	private int configId;
	/**
	 * 当前祝福值
	 */
	private int blessingValue;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

		public int getBlessingValue() {
		return blessingValue;
	}

	public void setBlessingValue(int blessingValue) {
		this.blessingValue = blessingValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.configId = readInt(buf, false);
		this.blessingValue = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeInt(buf, configId, false);
		this.writeInt(buf, blessingValue, false);
		return true;
	}
}
