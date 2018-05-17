package com.sh.game.system.xinfa.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class HeartMethodBean extends KryoBean {

	/**
	 * 心法位置
	 */
	private int position;
	/**
	 * 心法id
	 */
	private int methodId;
	/**
	 * 心法等级
	 */
	private int level;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

		public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.position = readInt(buf, false);
		this.methodId = readInt(buf, false);
		this.level = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, position, false);
		this.writeInt(buf, methodId, false);
		this.writeInt(buf, level, false);
		return true;
	}
}
