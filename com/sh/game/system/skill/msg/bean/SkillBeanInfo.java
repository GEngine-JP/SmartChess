package com.sh.game.system.skill.msg.bean;

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

public class SkillBeanInfo extends KryoBean {

	/**
	 * 技能信息
	 */
	private List<SkillBean> skillInfo = new ArrayList<>();
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色1英雄2
	 */
	private int type;
	/**
	 * 战斗力
	 */
	private int fightValue;

	public List<SkillBean> getSkillInfo() {
		return skillInfo;
	}

	public void setSkillInfo(List<SkillBean> skillInfo) {
		this.skillInfo = skillInfo;
	}
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int skillInfoLength = readShort(buf);
		for (int skillInfoI = 0; skillInfoI < skillInfoLength; skillInfoI++) {
			if (readByte(buf) == 0) { 
				this.skillInfo.add(null);
			} else {
				SkillBean skillBean = new SkillBean();
				skillBean.read(buf);
				this.skillInfo.add(skillBean);
			}
		}		this.heroId = readLong(buf);
		this.type = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.skillInfo.size());
		for (int skillInfoI = 0; skillInfoI < this.skillInfo.size(); skillInfoI++) {
			this.writeBean(buf, this.skillInfo.get(skillInfoI));
		}		this.writeLong(buf, heroId);
		this.writeInt(buf, type, false);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
