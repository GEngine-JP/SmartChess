package com.sh.game.system.boss.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ItemBean extends KryoBean {

	/**
	 * itemId
	 */
	private int itemId;

	/**
	 * 数量
	 */
	private int count;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);

		return true;
	}
}

