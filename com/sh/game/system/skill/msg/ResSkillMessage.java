package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.skill.msg.bean.SkillBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回角色技能数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
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
	private List<SkillBean> skillList = new ArrayList<SkillBean>();

	/**
	 * 战斗力
	 */
	private int fightValue;


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
		}

		this.fightValue = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.skillList.size());
		for (int skillListI = 0; skillListI < this.skillList.size(); skillListI++) {
			this.writeBean(buf, this.skillList.get(skillListI));
		}

		this.writeInt(buf, fightValue, false);

		return true;
	}
}

