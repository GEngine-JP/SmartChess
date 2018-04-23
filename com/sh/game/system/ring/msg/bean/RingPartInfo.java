package com.sh.game.system.ring.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class RingPartInfo extends KryoBean {

	/**
	 * 所属特戒类型
	 */
	private int type;
	/**
	 * 部位等级
	 */
	private int level;
	/**
	 * 部位位置
	 */
	private int position;

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

		public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.level = readInt(buf, false);
		this.position = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, position, false);
		return true;
	}
}
