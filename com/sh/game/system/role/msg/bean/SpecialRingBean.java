package com.sh.game.system.role.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class SpecialRingBean extends KryoBean {

	/**
	 * 特戒类型
	 */
	private int type;
	/**
	 * 特戒等级
	 */
	private int level;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.level = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, level, false);
		return true;
	}
}
