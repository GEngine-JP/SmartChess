package com.sh.game.system.equip.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class LingBaoBean extends KryoBean {

	/**
	 * 装备位置
	 */
	private int index;

	/**
	 * 唯一id
	 */
	private long uniqueId;

	/**
	 * 道具id
	 */
	private int itemId;

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 当前经验
	 */
	private int nowExp;

	/**
	 * 总经验
	 */
	private int totalExp;

	/**
	 * 灵宝战力
	 */
	private int power;


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
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

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getNowExp() {
		return nowExp;
	}

	public void setNowExp(int nowExp) {
		this.nowExp = nowExp;
	}

	
	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.index = readInt(buf, false);
		this.uniqueId = readLong(buf);
		this.itemId = readInt(buf, false);
		this.level = readInt(buf, false);
		this.nowExp = readInt(buf, false);
		this.totalExp = readInt(buf, false);
		this.power = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, index, false);
		this.writeLong(buf, uniqueId);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, nowExp, false);
		this.writeInt(buf, totalExp, false);
		this.writeInt(buf, power, false);

		return true;
	}
}

