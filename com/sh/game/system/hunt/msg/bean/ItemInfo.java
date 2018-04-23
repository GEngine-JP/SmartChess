package com.sh.game.system.hunt.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ItemInfo extends KryoBean {

	/**
	 * 唯一id
	 */
	private long uniqueId;
	/**
	 * 宝物id
	 */
	private int itemId;
	/**
	 * 宝物数量
	 */
	private int count;
	/**
	 * 极品属性
	 */
	private BestAttBean bestAttBean;

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

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

		public BestAttBean getBestAttBean() {
		return bestAttBean;
	}

	public void setBestAttBean(BestAttBean bestAttBean) {
		this.bestAttBean = bestAttBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readLong(buf);
		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);
		if (readByte(buf) != 0) {
			BestAttBean bestAttBean = new BestAttBean();
			bestAttBean.read(buf);
			this.bestAttBean = bestAttBean;
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uniqueId);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);
		this.writeBean(buf, bestAttBean);
		return true;
	}
}
