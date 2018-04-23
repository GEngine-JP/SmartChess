package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回领取日活奖励结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawDailyActiveRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawDailyActiveRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56005;
	}
	
	/**
	 * 已领取列表
	 */
	private List<Integer> rewardDrawList = new ArrayList<>();

	public List<Integer> getRewardDrawList() {
		return rewardDrawList;
	}

	public void setRewardDrawList(List<Integer> rewardDrawList) {
		this.rewardDrawList = rewardDrawList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int rewardDrawListLength = readShort(buf);
		for (int rewardDrawListI = 0; rewardDrawListI < rewardDrawListLength; rewardDrawListI++) {
			this.rewardDrawList.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rewardDrawList.size());
		for (int rewardDrawListI = 0; rewardDrawListI < this.rewardDrawList.size(); rewardDrawListI++) {
			this.writeInt(buf, this.rewardDrawList.get(rewardDrawListI), false);
		}
		return true;
	}
}
