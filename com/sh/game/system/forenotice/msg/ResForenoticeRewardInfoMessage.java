package com.sh.game.system.forenotice.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回功能预告领奖信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResForenoticeRewardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResForenoticeRewardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 29001;
	}
	
	/**
	 * 已领取奖励列表
	 */
	private List<Integer> rewardList = new ArrayList<>();

	public List<Integer> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<Integer> rewardList) {
		this.rewardList = rewardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int rewardListLength = readShort(buf);
		for (int rewardListI = 0; rewardListI < rewardListLength; rewardListI++) {
			this.rewardList.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rewardList.size());
		for (int rewardListI = 0; rewardListI < this.rewardList.size(); rewardListI++) {
			this.writeInt(buf, this.rewardList.get(rewardListI), false);
		}
		return true;
	}
}
