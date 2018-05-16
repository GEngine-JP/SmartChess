package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.skill.msg.bean.SkillBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回多个技能变化数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResMultiSkillChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMultiSkillChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9011;
	}
	
	/**
	 * 改变的技能列表
	 */
	private List<SkillBean> skillList = new ArrayList<>();
	/**
	 * 战斗力
	 */
	private int fightValue;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色1英雄2
	 */
	private int type;

	public List<SkillBean> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<SkillBean> skillList) {
		this.skillList = skillList;
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

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int skillListLength = readShort(buf);
		for (int skillListI = 0; skillListI < skillListLength; skillListI++) {
			if (readByte(buf) == 0) { 
				this.skillList.add(null);
			} else {
				SkillBean skillBean = new SkillBean();
				skillBean.read(buf);
				this.skillList.add(skillBean);
			}
		}		this.fightValue = readInt(buf, false);
		this.heroId = readLong(buf);
		this.type = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.skillList.size());
		for (int skillListI = 0; skillListI < this.skillList.size(); skillListI++) {
			this.writeBean(buf, this.skillList.get(skillListI));
		}		this.writeInt(buf, fightValue, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, type, false);
		return true;
	}
}