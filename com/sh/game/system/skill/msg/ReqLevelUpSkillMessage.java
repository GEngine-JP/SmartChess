package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求单独升级技能</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLevelUpSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9003;
	}
	
	/**
	 * 技能id
	 */
	private int skillId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.skillId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, skillId, false);
		return true;
	}
}
