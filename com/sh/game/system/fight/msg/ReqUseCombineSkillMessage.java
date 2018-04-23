package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求使用合击技能</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
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

	
	@Override
	public boolean read(KryoInput buf) {

		this.skillId = readInt(buf, false);
		this.wave = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, skillId, false);
		this.writeInt(buf, wave, false);
		return true;
	}
}
