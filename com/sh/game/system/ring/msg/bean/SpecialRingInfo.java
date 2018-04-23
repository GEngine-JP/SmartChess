package com.sh.game.system.ring.msg.bean;

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

public class SpecialRingInfo extends KryoBean {

	/**
	 * 特戒类型
	 */
	private int type;
	/**
	 * 部位信息
	 */
	private List<RingPartInfo> partInfos = new ArrayList<>();
	/**
	 * 特戒等级
	 */
	private int level;
	/**
	 * 战斗力
	 */
	private int nbValue;
	/**
	 * 英雄id
	 */
	private long heroId;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public List<RingPartInfo> getPartInfos() {
		return partInfos;
	}

	public void setPartInfos(List<RingPartInfo> partInfos) {
		this.partInfos = partInfos;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getNbValue() {
		return nbValue;
	}

	public void setNbValue(int nbValue) {
		this.nbValue = nbValue;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		int partInfosLength = readShort(buf);
		for (int partInfosI = 0; partInfosI < partInfosLength; partInfosI++) {
			if (readByte(buf) == 0) { 
				this.partInfos.add(null);
			} else {
				RingPartInfo ringPartInfo = new RingPartInfo();
				ringPartInfo.read(buf);
				this.partInfos.add(ringPartInfo);
			}
		}		this.level = readInt(buf, false);
		this.nbValue = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		writeShort(buf, this.partInfos.size());
		for (int partInfosI = 0; partInfosI < this.partInfos.size(); partInfosI++) {
			this.writeBean(buf, this.partInfos.get(partInfosI));
		}		this.writeInt(buf, level, false);
		this.writeInt(buf, nbValue, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
