package com.sh.game.system.bag.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class CoinBean extends KryoBean {

	/**
	 * 货币ID
	 */
	private int itemId;

	/**
	 * 货币数量
	 */
	private long count;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);
		this.count = readLong(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);
		this.writeLong(buf, count);

		return true;
	}
}

