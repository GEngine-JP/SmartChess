package com.sh.game.system.refine.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class RefineBean extends KryoBean {

	/**
	 * 装备位置
	 */
	private int equipSlot;
	/**
	 * 精炼等级
	 */
	private int refileLevel;

	public int getEquipSlot() {
		return equipSlot;
	}

	public void setEquipSlot(int equipSlot) {
		this.equipSlot = equipSlot;
	}

		public int getRefileLevel() {
		return refileLevel;
	}

	public void setRefileLevel(int refileLevel) {
		this.refileLevel = refileLevel;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.equipSlot = readInt(buf, false);
		this.refileLevel = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, equipSlot, false);
		this.writeInt(buf, refileLevel, false);
		return true;
	}
}
