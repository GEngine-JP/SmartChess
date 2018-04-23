package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>领取天梯段位奖励的返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLadderRankRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderRankRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5015;
	}
	
	/**
	 * 领取状态 0不可领 1为可领取 2为已领取
	 */
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.state = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, state, false);
		return true;
	}
}
