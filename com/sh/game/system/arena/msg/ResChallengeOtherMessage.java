package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回挑战其他玩家</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResChallengeOtherMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResChallengeOtherMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37009;
	}
	
	/**
	 * 状态 1可以打 其余是lang表id
	 */
	private int state;

	/**
	 * 目标玩家排名
	 */
	private int targetRank;


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public int getTargetRank() {
		return targetRank;
	}

	public void setTargetRank(int targetRank) {
		this.targetRank = targetRank;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.state = readInt(buf, false);
		this.targetRank = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, state, false);
		this.writeInt(buf, targetRank, false);

		return true;
	}
}

