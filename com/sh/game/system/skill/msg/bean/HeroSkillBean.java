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

public class HeroSkillBean extends KryoBean {

	/**
	 * 技能信息
	 */
	private List<SkillBean> skills = new ArrayList<>();
	/**
	 * 英雄id
	 */
	private long heroId;

	public List<SkillBean> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillBean> skills) {
		this.skills = skills;
	}
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int skillsLength = readShort(buf);
		for (int skillsI = 0; skillsI < skillsLength; skillsI++) {
			if (readByte(buf) == 0) { 
				this.skills.add(null);
			} else {
				SkillBean skillBean = new SkillBean();
				skillBean.read(buf);
				this.skills.add(skillBean);
			}
		}		this.heroId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.skills.size());
		for (int skillsI = 0; skillsI < this.skills.size(); skillsI++) {
			this.writeBean(buf, this.skills.get(skillsI));
		}		this.writeLong(buf, heroId);
		return true;
	}
}
