package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送个人积分面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendPersonScoreInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendPersonScoreInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40011;
	}
	
	/**
	 * 已领取的达标奖励（配置表id）
	 */
	private List<Integer> hasReward = new ArrayList<Integer>();

	/**
	 * 个人积分量
	 */
	private int personScore;


	public List<Integer> getHasReward() {
		return hasReward;
	}

	public void setHasReward(List<Integer> hasReward) {
		this.hasReward = hasReward;
	}

	public int getPersonScore() {
		return personScore;
	}

	public void setPersonScore(int personScore) {
		this.personScore = personScore;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int hasRewardLength = readShort(buf);
		for (int hasRewardI = 0; hasRewardI < hasRewardLength; hasRewardI++) {
			this.hasReward.add(this.readInt(buf, false));
		}

		this.personScore = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.hasReward.size());
		for (int hasRewardI = 0; hasRewardI < this.hasReward.size(); hasRewardI++) {
			this.writeInt(buf, this.hasReward.get(hasRewardI), false);
		}

		this.writeInt(buf, personScore, false);

		return true;
	}
}

