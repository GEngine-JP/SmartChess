package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class BufferDataBean extends KryoBean {

	/**
	 * 目标id
	 */
	private long targetId;

	/**
	 * 技能id
	 */
	private int skillId;


	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	
	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetId = readLong(buf);
		this.skillId = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, targetId);
		this.writeInt(buf, skillId, false);

		return true;
	}
}

