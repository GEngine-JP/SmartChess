package com.sh.game.system.chat.msg.bean;

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

public class HeroInfoBean extends KryoBean {

	/**
	 * 翅膀id
	 */
	private int windId;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 战力
	 */
	private int fightPower;
	/**
	 * 英雄基本属性
	 */
	private AttributeBean heroAttribute;
	/**
	 * 装备列表
	 */
	private List<EquipItemBean> equipItemBeanList = new ArrayList<>();
	/**
	 * 强化列表
	 */
	private List<Integer> strengthList = new ArrayList<>();
	/**
	 * 灵宝列表
	 */
	private List<LingBaoBean> lbList = new ArrayList<>();
	/**
	 * 特戒列表
	 */
	private List<RingBean> ringList = new ArrayList<>();
	/**
	 * 神装战力
	 */
	private int szFightPower;
	/**
	 * 神装套装
	 */
	private int szSuit;
	/**
	 * 神装数量
	 */
	private int szCount;

	public int getWindId() {
		return windId;
	}

	public void setWindId(int windId) {
		this.windId = windId;
	}

		public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

		public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

		public AttributeBean getHeroAttribute() {
		return heroAttribute;
	}

	public void setHeroAttribute(AttributeBean heroAttribute) {
		this.heroAttribute = heroAttribute;
	}

		public List<EquipItemBean> getEquipItemBeanList() {
		return equipItemBeanList;
	}

	public void setEquipItemBeanList(List<EquipItemBean> equipItemBeanList) {
		this.equipItemBeanList = equipItemBeanList;
	}
	public List<Integer> getStrengthList() {
		return strengthList;
	}

	public void setStrengthList(List<Integer> strengthList) {
		this.strengthList = strengthList;
	}
	public List<LingBaoBean> getLbList() {
		return lbList;
	}

	public void setLbList(List<LingBaoBean> lbList) {
		this.lbList = lbList;
	}
	public List<RingBean> getRingList() {
		return ringList;
	}

	public void setRingList(List<RingBean> ringList) {
		this.ringList = ringList;
	}
	public int getSzFightPower() {
		return szFightPower;
	}

	public void setSzFightPower(int szFightPower) {
		this.szFightPower = szFightPower;
	}

		public int getSzSuit() {
		return szSuit;
	}

	public void setSzSuit(int szSuit) {
		this.szSuit = szSuit;
	}

		public int getSzCount() {
		return szCount;
	}

	public void setSzCount(int szCount) {
		this.szCount = szCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.windId = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.level = readInt(buf, false);
		this.fightPower = readInt(buf, false);
		if (readByte(buf) != 0) {
			AttributeBean attributeBean = new AttributeBean();
			attributeBean.read(buf);
			this.heroAttribute = attributeBean;
		}
		int equipItemBeanListLength = readShort(buf);
		for (int equipItemBeanListI = 0; equipItemBeanListI < equipItemBeanListLength; equipItemBeanListI++) {
			if (readByte(buf) == 0) { 
				this.equipItemBeanList.add(null);
			} else {
				EquipItemBean equipItemBean = new EquipItemBean();
				equipItemBean.read(buf);
				this.equipItemBeanList.add(equipItemBean);
			}
		}		int strengthListLength = readShort(buf);
		for (int strengthListI = 0; strengthListI < strengthListLength; strengthListI++) {
			this.strengthList.add(this.readInt(buf, false));
		}		int lbListLength = readShort(buf);
		for (int lbListI = 0; lbListI < lbListLength; lbListI++) {
			if (readByte(buf) == 0) { 
				this.lbList.add(null);
			} else {
				LingBaoBean lingBaoBean = new LingBaoBean();
				lingBaoBean.read(buf);
				this.lbList.add(lingBaoBean);
			}
		}		int ringListLength = readShort(buf);
		for (int ringListI = 0; ringListI < ringListLength; ringListI++) {
			if (readByte(buf) == 0) { 
				this.ringList.add(null);
			} else {
				RingBean ringBean = new RingBean();
				ringBean.read(buf);
				this.ringList.add(ringBean);
			}
		}		this.szFightPower = readInt(buf, false);
		this.szSuit = readInt(buf, false);
		this.szCount = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, windId, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, fightPower, false);
		this.writeBean(buf, heroAttribute);
		writeShort(buf, this.equipItemBeanList.size());
		for (int equipItemBeanListI = 0; equipItemBeanListI < this.equipItemBeanList.size(); equipItemBeanListI++) {
			this.writeBean(buf, this.equipItemBeanList.get(equipItemBeanListI));
		}		writeShort(buf, this.strengthList.size());
		for (int strengthListI = 0; strengthListI < this.strengthList.size(); strengthListI++) {
			this.writeInt(buf, this.strengthList.get(strengthListI), false);
		}		writeShort(buf, this.lbList.size());
		for (int lbListI = 0; lbListI < this.lbList.size(); lbListI++) {
			this.writeBean(buf, this.lbList.get(lbListI));
		}		writeShort(buf, this.ringList.size());
		for (int ringListI = 0; ringListI < this.ringList.size(); ringListI++) {
			this.writeBean(buf, this.ringList.get(ringListI));
		}		this.writeInt(buf, szFightPower, false);
		this.writeInt(buf, szSuit, false);
		this.writeInt(buf, szCount, false);
		return true;
	}
}
