package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取总成就奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqAllAchievementRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAllAchievementRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17006;
	}
	
	/**
	 * 成就奖励id
	 */
	private int rewardId;

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rewardId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rewardId, false);
		return true;
	}
}
