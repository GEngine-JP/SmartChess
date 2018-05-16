package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.skill.msg.bean.SkillBeanInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>英雄合击技能变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCombineSkillInfoChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCombineSkillInfoChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9010;
	}
	
	/**
	 * 变化的英雄合击技能
	 */
	private List<SkillBeanInfo> heroSkill = new ArrayList<>();
	/**
	 * 是否已激活 1激活
	 */
	private int isActive;

	public List<SkillBeanInfo> getHeroSkill() {
		return heroSkill;
	}

	public void setHeroSkill(List<SkillBeanInfo> heroSkill) {
		this.heroSkill = heroSkill;
	}
	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int heroSkillLength = readShort(buf);
		for (int heroSkillI = 0; heroSkillI < heroSkillLength; heroSkillI++) {
			if (readByte(buf) == 0) { 
				this.heroSkill.add(null);
			} else {
				SkillBeanInfo skillBeanInfo = new SkillBeanInfo();
				skillBeanInfo.read(buf);
				this.heroSkill.add(skillBeanInfo);
			}
		}		this.isActive = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.heroSkill.size());
		for (int heroSkillI = 0; heroSkillI < this.heroSkill.size(); heroSkillI++) {
			this.writeBean(buf, this.heroSkill.get(heroSkillI));
		}		this.writeInt(buf, isActive, false);
		return true;
	}
}
