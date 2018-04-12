package com.sh.game.system.equip.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class SoulStoneBean extends KryoBean {

	/**
	 * 魂石类型
	 */
	private int stoneType;

	/**
	 * 魂石等级
	 */
	private int level;


	public int getStoneType() {
		return stoneType;
	}

	public void setStoneType(int stoneType) {
		this.stoneType = stoneType;
	}

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.stoneType = readInt(buf, false);
		this.level = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, stoneType, false);
		this.writeInt(buf, level, false);

		return true;
	}
}

