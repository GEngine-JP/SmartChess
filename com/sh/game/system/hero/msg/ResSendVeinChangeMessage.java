package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.hero.msg.bean.HeroSkillBean;
import com.sh.game.system.hero.msg.bean.HeroAttribute;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送英雄经脉变化信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendVeinChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendVeinChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22014;
	}
	
	/**
	 * 技能变化信息
	 */
	private List<HeroSkillBean> skillInfo = new ArrayList<HeroSkillBean>();

	/**
	 * 现在的配置表id
	 */
	private int newId;

	/**
	 * 经脉属性
	 */
	private HeroAttribute veinAttribute;

	/**
	 * 战斗力
	 */
	private int fightValue;

	/**
	 * 英雄Id
	 */
	private long heroId;


	public List<HeroSkillBean> getSkillInfo() {
		return skillInfo;
	}

	public void setSkillInfo(List<HeroSkillBean> skillInfo) {
		this.skillInfo = skillInfo;
	}

	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

	
	public HeroAttribute getVeinAttribute() {
		return veinAttribute;
	}

	public void setVeinAttribute(HeroAttribute veinAttribute) {
		this.veinAttribute = veinAttribute;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int skillInfoLength = readShort(buf);
		for (int skillInfoI = 0; skillInfoI < skillInfoLength; skillInfoI++) {
			if (readByte(buf) == 0) { 
				this.skillInfo.add(null);
			} else {
				HeroSkillBean heroSkillBean = new HeroSkillBean();
				heroSkillBean.read(buf);
				this.skillInfo.add(heroSkillBean);
			}
		}

		this.newId = readInt(buf, false);
		if (readByte(buf) != 0) {
			HeroAttribute heroAttribute = new HeroAttribute();
			heroAttribute.read(buf);
			this.veinAttribute = heroAttribute;
		}
		this.fightValue = readInt(buf, false);
		this.heroId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.skillInfo.size());
		for (int skillInfoI = 0; skillInfoI < this.skillInfo.size(); skillInfoI++) {
			this.writeBean(buf, this.skillInfo.get(skillInfoI));
		}

		this.writeInt(buf, newId, false);
		this.writeBean(buf, veinAttribute);
		this.writeInt(buf, fightValue, false);
		this.writeLong(buf, heroId);

		return true;
	}
}

