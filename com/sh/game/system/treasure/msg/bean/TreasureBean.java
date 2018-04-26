package com.sh.game.system.treasure.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class TreasureBean extends KryoBean {

	/**
	 * 装备位置
	 */
	private int index;
	/**
	 * 宝物id
	 */
	private int itemId;
	/**
	 * 宝物类型 1.神弓 2.神斧 3.神剑 4.法宝
	 */
	private int type;
	/**
	 * 战斗力
	 */
	private int power;
	/**
	 * 英雄id
	 */
	private long heroId;

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

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.index = readInt(buf, false);
		this.itemId = readInt(buf, false);
		this.type = readInt(buf, false);
		this.power = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, index, false);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, type, false);
		this.writeInt(buf, power, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
