package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送竞技场结算信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResArenaRankRewardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResArenaRankRewardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37013;
	}
	
	/**
	 * 结算时排名
	 */
	private int oldRank;
	/**
	 * 奖励状态 1.可领取 2.已领取
	 */
	private int rewardState;

	public int getOldRank() {
		return oldRank;
	}

	public void setOldRank(int oldRank) {
		this.oldRank = oldRank;
	}

		public int getRewardState() {
		return rewardState;
	}

	public void setRewardState(int rewardState) {
		this.rewardState = rewardState;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.oldRank = readInt(buf, false);
		this.rewardState = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, oldRank, false);
		this.writeInt(buf, rewardState, false);
		return true;
	}
}
