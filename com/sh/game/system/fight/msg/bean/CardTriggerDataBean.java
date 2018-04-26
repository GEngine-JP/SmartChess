package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class CardTriggerDataBean extends KryoBean {

	/**
	 * 类型 1回血
	 */
	private int type;
	/**
	 * 1为触发
	 */
	private int isTrigger;
	/**
	 * 参数
	 */
	private int param;

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

		public int getParam() {
		return param;
	}

	public void setParam(int param) {
		this.param = param;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.isTrigger = readInt(buf, false);
		this.param = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, isTrigger, false);
		this.writeInt(buf, param, false);
		return true;
	}
}
