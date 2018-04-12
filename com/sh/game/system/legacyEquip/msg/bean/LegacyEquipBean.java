package com.sh.game.system.legacyEquip.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class LegacyEquipBean extends KryoBean {

	/**
	 * 装备位置
	 */
	private int index;

	/**
	 * 传世装备id
	 */
	private int itemId;


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.index = readInt(buf, false);
		this.itemId = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, index, false);
		this.writeInt(buf, itemId, false);

		return true;
	}
}

