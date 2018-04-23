package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求激活技能</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqActiveRolekillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqActiveRolekillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9005;
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
