package com.sh.game.system.battle.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求使用连击技能</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUseCombSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseCombSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 60004;
	}
	
	/**
	 * 回合数
	 */
	private int round;

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.round = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, round, false);
		return true;
	}
}
