package com.sh.game.system.tower.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class WheelBean extends KryoBean {

	/**
	 * 道具id
	 */
	private int itemId;
	/**
	 * 数量
	 */
	private int count;
	/**
	 * 位置
	 */
	private int index;
	/**
	 * 状态 0未领取 1已领取
	 */
	private int state;

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

		public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);
		this.index = readInt(buf, false);
		this.state = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);
		this.writeInt(buf, index, false);
		this.writeInt(buf, state, false);
		return true;
	}
}
