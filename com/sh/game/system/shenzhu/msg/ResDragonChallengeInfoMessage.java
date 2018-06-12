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
	 * 0.可接受 1.可挑战 2.可完成 3.可领奖 4.已领奖 
	 */
	private int state;
	/**
	 * 当前进度
	 */
	private int nowCount;

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

		public int getNowCount() {
		return nowCount;
	}

	public void setNowCount(int nowCount) {
		this.nowCount = nowCount;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.challengeId = readInt(buf, false);
		this.state = readInt(buf, false);
		this.nowCount = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, challengeId, false);
		this.writeInt(buf, state, false);
		this.writeInt(buf, nowCount, false);
		return true;
	}
}
