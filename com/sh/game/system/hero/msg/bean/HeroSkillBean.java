package com.sh.game.system.hero.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class HeroSkillBean extends KryoBean {

	/**
	 * 技能id
	 */
	private int skillId;
	/**
	 * 等级
	 */
	private int level;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.skillId = readInt(buf, false);
		this.level = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, skillId, false);
		this.writeInt(buf, level, false);
		return true;
	}
}
