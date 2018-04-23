package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.skill.msg.bean.SkillBean;

/**
 * <p>返回角色技能变化数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendSkillChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSkillChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9006;
	}
	
	/**
	 * 改变的技能
	 */
	private SkillBean skillBean;
	/**
	 * 战斗力
	 */
	private int fightValue;

	public SkillBean getSkillBean() {
		return skillBean;
	}

	public void setSkillBean(SkillBean skillBean) {
		this.skillBean = skillBean;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			SkillBean skillBean = new SkillBean();
			skillBean.read(buf);
			this.skillBean = skillBean;
		}
		this.fightValue = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, skillBean);
		this.writeInt(buf, fightValue, false);
		return true;
	}
}
