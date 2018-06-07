package com.sh.game.system.shenzhu.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送龙珠挑战信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDragonChallengeInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDragonChallengeInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 47004;
	}
	
	/**
	 * id
	 */
	private int challengeId;
	/**
	 * 0.可接受 1.可挑战 2.可领奖
	 */
	private int state;

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.challengeId = readInt(buf, false);
		this.state = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, challengeId, false);
		this.writeInt(buf, state, false);
		return true;
	}
}
