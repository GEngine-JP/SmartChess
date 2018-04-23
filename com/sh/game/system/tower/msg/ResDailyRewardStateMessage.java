package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回每日奖励领奖状态</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDailyRewardStateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDailyRewardStateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54004;
	}
	
	/**
	 * 每日奖励领奖状态 0不可领奖 1可领取 2已领取
	 */
	private int rewardState;

	public int getRewardState() {
		return rewardState;
	}

	public void setRewardState(int rewardState) {
		this.rewardState = rewardState;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rewardState = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rewardState, false);
		return true;
	}
}
