package com.sh.game.system.legacyEquip.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class LegacyEquipBean extends KryoBean {

	/**
	 * 角色或英雄唯一id
	 */
	private long uid;
	/**
	 * 装备位置
	 */
	private int index;
	/**
	 * 传世装备id
	 */
	private int itemId;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

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

		this.uid = readLong(buf);
		this.index = readInt(buf, false);
		this.itemId = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uid);
		this.writeInt(buf, index, false);
		this.writeInt(buf, itemId, false);
		return true;
	}
}
