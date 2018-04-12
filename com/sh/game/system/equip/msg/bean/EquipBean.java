package com.sh.game.system.equip.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.equip.msg.bean.BestAttBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class EquipBean extends KryoBean {

	/**
	 * 装备位置
	 */
	private int index;

	/**
	 * 唯一id
	 */
	private long lid;

	/**
	 * 道具id
	 */
	private int itemId;

	/**
	 * 过期时间
	 */
	private int time;

	/**
	 * 是否绑定
	 */
	private byte bind;

	/**
	 * 该装备位置强化等级
	 */
	private int improveLevel;

	/**
	 * 额外属性key
	 */
	private List<Byte> extraType = new ArrayList<Byte>();

	/**
	 * 额外属性value
	 */
	private List<Integer> extraVlaue = new ArrayList<Integer>();

	/**
	 * 灵魂刻印的属性加成数
	 */
	private int soulUp;

	/**
	 * 极品属性
	 */
	private BestAttBean bestAttBean;


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	public byte getBind() {
		return bind;
	}

	public void setBind(byte bind) {
		this.bind = bind;
	}

	
	public int getImproveLevel() {
		return improveLevel;
	}

	public void setImproveLevel(int improveLevel) {
		this.improveLevel = improveLevel;
	}

	
	public List<Byte> getExtraType() {
		return extraType;
	}

	public void setExtraType(List<Byte> extraType) {
		this.extraType = extraType;
	}

	public List<Integer> getExtraVlaue() {
		return extraVlaue;
	}

	public void setExtraVlaue(List<Integer> extraVlaue) {
		this.extraVlaue = extraVlaue;
	}

	public int getSoulUp() {
		return soulUp;
	}

	public void setSoulUp(int soulUp) {
		this.soulUp = soulUp;
	}

	
	public BestAttBean getBestAttBean() {
		return bestAttBean;
	}

	public void setBestAttBean(BestAttBean bestAttBean) {
		this.bestAttBean = bestAttBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.index = readInt(buf, false);
		this.lid = readLong(buf);
		this.itemId = readInt(buf, false);
		this.time = readInt(buf, false);
		this.bind = readByte(buf);
		this.improveLevel = readInt(buf, false);
		int extraTypeLength = readShort(buf);
		for (int extraTypeI = 0; extraTypeI < extraTypeLength; extraTypeI++) {
			this.extraType.add(readByte(buf));
		}

		int extraVlaueLength = readShort(buf);
		for (int extraVlaueI = 0; extraVlaueI < extraVlaueLength; extraVlaueI++) {
			this.extraVlaue.add(this.readInt(buf, false));
		}

		this.soulUp = readInt(buf, false);
		if (readByte(buf) != 0) {
			BestAttBean bestAttBean = new BestAttBean();
			bestAttBean.read(buf);
			this.bestAttBean = bestAttBean;
		}

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, index, false);
		this.writeLong(buf, lid);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, time, false);
		this.writeByte(buf, bind);
		this.writeInt(buf, improveLevel, false);
		writeShort(buf, this.extraType.size());
		for (int extraTypeI = 0; extraTypeI < this.extraType.size(); extraTypeI++) {
			this.writeByte(buf, this.extraType.get(extraTypeI));
		}

		writeShort(buf, this.extraVlaue.size());
		for (int extraVlaueI = 0; extraVlaueI < this.extraVlaue.size(); extraVlaueI++) {
			this.writeInt(buf, this.extraVlaue.get(extraVlaueI), false);
		}

		this.writeInt(buf, soulUp, false);
		this.writeBean(buf, bestAttBean);

		return true;
	}
}

