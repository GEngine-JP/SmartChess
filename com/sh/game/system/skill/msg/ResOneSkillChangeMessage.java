package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.skill.msg.bean.SkillBean;

/**
 * <p>返回单个技能变化数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOneSkillChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOneSkillChangeMessage() {
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
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色1英雄2
	 */
	private int type;

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

		if (readByte(buf) != 0) {
			SkillBean skillBean = new SkillBean();
			skillBean.read(buf);
			this.skillBean = skillBean;
		}
		this.fightValue = readInt(buf, false);
		this.heroId = readLong(buf);
		this.type = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, skillBean);
		this.writeInt(buf, fightValue, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, type, false);
		return true;
	}
}
