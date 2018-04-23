package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求多人副本使用合击技能（打怪物）</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqMultiInsCombineSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqMultiInsCombineSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25011;
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
