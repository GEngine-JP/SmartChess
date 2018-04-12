package com.sh.game.system.wing.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class WingEquipBean extends KryoBean {

	/**
	 * 光翼装备类型
	 */
	private int wingEquipType;

	/**
	 * 光翼装备id
	 */
	private int wingEquipId;


	public int getWingEquipType() {
		return wingEquipType;
	}

	public void setWingEquipType(int wingEquipType) {
		this.wingEquipType = wingEquipType;
	}

	
	public int getWingEquipId() {
		return wingEquipId;
	}

	public void setWingEquipId(int wingEquipId) {
		this.wingEquipId = wingEquipId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.wingEquipType = readInt(buf, false);
		this.wingEquipId = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, wingEquipType, false);
		this.writeInt(buf, wingEquipId, false);

		return true;
	}
}

