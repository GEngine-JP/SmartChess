package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求多人副本使用合击技能（打怪物）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
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

	/**
	 * 副本唯一id
	 */
	private int uniqueId;


	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	
	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.skillId = readInt(buf, false);
		this.uniqueId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, skillId, false);
		this.writeInt(buf, uniqueId, false);

		return true;
	}
}

