package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求使用合击技能</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqUseCombineSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseCombineSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25006;
	}
	
	/**
	 * 技能id
	 */
	private int skillId;

	/**
	 * 回合数
	 */
	private int wave;

	/**
	 * 副本id
	 */
	private int instanceId;

	/**
	 * 排行id
	 */
	private int targetRank;


	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	
	public int getWave() {
		return wave;
	}

	public void setWave(int wave) {
		this.wave = wave;
	}

	
	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	
	public int getTargetRank() {
		return targetRank;
	}

	public void setTargetRank(int targetRank) {
		this.targetRank = targetRank;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.skillId = readInt(buf, false);
		this.wave = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.targetRank = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, skillId, false);
		this.writeInt(buf, wave, false);
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, targetRank, false);

		return true;
	}
}

