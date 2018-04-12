package com.sh.game.system.equip.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class StrengthBean extends KryoBean {

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 经验
	 */
	private int exp;


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.level = readInt(buf, false);
		this.exp = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, level, false);
		this.writeInt(buf, exp, false);

		return true;
	}
}

