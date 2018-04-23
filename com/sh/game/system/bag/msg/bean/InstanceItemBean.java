package com.sh.game.system.bag.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class InstanceItemBean extends KryoBean {

	/**
	 * 配置id
	 */
	private int globalId;
	/**
	 * 已使用次数
	 */
	private int useNum;

	public int getGlobalId() {
		return globalId;
	}

	public void setGlobalId(int globalId) {
		this.globalId = globalId;
	}

		public int getUseNum() {
		return useNum;
	}

	public void setUseNum(int useNum) {
		this.useNum = useNum;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.globalId = readInt(buf, false);
		this.useNum = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, globalId, false);
		this.writeInt(buf, useNum, false);
		return true;
	}
}
