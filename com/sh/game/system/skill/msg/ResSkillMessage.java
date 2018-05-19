package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.skill.msg.bean.SkillBeanInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回角色技能数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9002;
	}
	
	/**
	 * 技能列表
	 */
	private List<SkillBeanInfo> skillList = new ArrayList<>();

	public List<SkillBeanInfo> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<SkillBeanInfo> skillList) {
		this.skillList = skillList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int skillListLength = readShort(buf);
		for (int skillListI = 0; skillListI < skillListLength; skillListI++) {
			if (readByte(buf) == 0) { 
				this.skillList.add(null);
			} else {
				SkillBeanInfo skillBeanInfo = new SkillBeanInfo();
				skillBeanInfo.read(buf);
				this.skillList.add(skillBeanInfo);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.skillList.size());
		for (int skillListI = 0; skillListI < this.skillList.size(); skillListI++) {
			this.writeBean(buf, this.skillList.get(skillListI));
		}
		return true;
	}
}
