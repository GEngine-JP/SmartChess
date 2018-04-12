package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求作假野外boss合击</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqFalseOutBossCombineSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFalseOutBossCombineSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20023;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;

	/**
	 * 技能id
	 */
	private int skillId;


	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readInt(buf, false);
		this.skillId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, skillId, false);

		return true;
	}
}

