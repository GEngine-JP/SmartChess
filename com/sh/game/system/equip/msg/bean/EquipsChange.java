package com.sh.game.system.equip.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.equip.msg.bean.EquipBean;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class EquipsChange extends KryoBean {

	/**
	 * 装备位置索引
	 */
	private int equipIndex;

	/**
	 * 更新的装备信息，如果为空，说明脱掉了
	 */
	private EquipBean changeEquip;


	public int getEquipIndex() {
		return equipIndex;
	}

	public void setEquipIndex(int equipIndex) {
		this.equipIndex = equipIndex;
	}

	
	public EquipBean getChangeEquip() {
		return changeEquip;
	}

	public void setChangeEquip(EquipBean changeEquip) {
		this.changeEquip = changeEquip;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.equipIndex = readInt(buf, false);
		if (readByte(buf) != 0) {
			EquipBean equipBean = new EquipBean();
			equipBean.read(buf);
			this.changeEquip = equipBean;
		}

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, equipIndex, false);
		this.writeBean(buf, changeEquip);

		return true;
	}
}

