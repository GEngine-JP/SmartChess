package com.sh.game.system.card.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class CardBean extends KryoBean {

	/**
	 * 位置1、2、3
	 */
	private int index;

	/**
	 * itemId
	 */
	private int itemId;

	/**
	 * uniqueId
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

