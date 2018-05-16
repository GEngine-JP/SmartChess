package com.sh.game.system.wing.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class WingEquipBean extends KryoBean {

	/**
	 * 位置
	 */
	private int index;
	/**
	 * 道具id
	 */
	private int itemId;
	/**
	 * 唯一id
	 */
	private long uniqueId;

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

		public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.itemId = readInt(buf, false);
		this.uniqueId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeInt(buf, itemId, false);
		this.writeLong(buf, uniqueId);
		return true;
	}
}
