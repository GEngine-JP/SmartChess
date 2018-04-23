package com.sh.game.system.bag.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class BagItemBean extends KryoBean {

	/**
	 * 唯一id
	 */
	private long lid;
	/**
	 * 道具id
	 */
	private int itemId;
	/**
	 * 道具数量
	 */
	private int count;
	/**
	 * 过期时间
	 */
	private int time;
	/**
	 * 是否绑定
	 */
	private byte bind;
	/**
	 * 额外属性key
	 */
	private List<Byte> extraType = new ArrayList<>();
	/**
	 * 额外属性value，和key一一对应，该属性主要是装备使用，道具也可以偶尔使用
	 */
	private List<Integer> extraVlaue = new ArrayList<>();
	/**
	 * 极品属性
	 */
	private BestAttBean bestAttBean;
	/**
	 * 灵宝属性
	 */
	private LingBaoBean lingBaoBean;

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

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
	public BestAttBean getBestAttBean() {
		return bestAttBean;
	}

	public void setBestAttBean(BestAttBean bestAttBean) {
		this.bestAttBean = bestAttBean;
	}

		public LingBaoBean getLingBaoBean() {
		return lingBaoBean;
	}

	public void setLingBaoBean(LingBaoBean lingBaoBean) {
		this.lingBaoBean = lingBaoBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.lid = readLong(buf);
		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);
		this.time = readInt(buf, false);
		this.bind = readByte(buf);
		int extraTypeLength = readShort(buf);
		for (int extraTypeI = 0; extraTypeI < extraTypeLength; extraTypeI++) {
			this.extraType.add(readByte(buf));
		}		int extraVlaueLength = readShort(buf);
		for (int extraVlaueI = 0; extraVlaueI < extraVlaueLength; extraVlaueI++) {
			this.extraVlaue.add(this.readInt(buf, false));
		}		if (readByte(buf) != 0) {
			BestAttBean bestAttBean = new BestAttBean();
			bestAttBean.read(buf);
			this.bestAttBean = bestAttBean;
		}
		if (readByte(buf) != 0) {
			LingBaoBean lingBaoBean = new LingBaoBean();
			lingBaoBean.read(buf);
			this.lingBaoBean = lingBaoBean;
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, lid);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);
		this.writeInt(buf, time, false);
		this.writeByte(buf, bind);
		writeShort(buf, this.extraType.size());
		for (int extraTypeI = 0; extraTypeI < this.extraType.size(); extraTypeI++) {
			this.writeByte(buf, this.extraType.get(extraTypeI));
		}		writeShort(buf, this.extraVlaue.size());
		for (int extraVlaueI = 0; extraVlaueI < this.extraVlaue.size(); extraVlaueI++) {
			this.writeInt(buf, this.extraVlaue.get(extraVlaueI), false);
		}		this.writeBean(buf, bestAttBean);
		this.writeBean(buf, lingBaoBean);
		return true;
	}
}
