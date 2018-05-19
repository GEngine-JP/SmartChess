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

public class VeinBean extends KryoBean {

	/**
	 * 现在的配置表id
	 */
	private int newId;
	/**
	 * 战斗力
	 */
	private int fightValue;

	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.newId = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, newId, false);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
