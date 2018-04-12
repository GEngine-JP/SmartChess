package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>已领取的成就列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAllAchievementRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAllAchievementRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17007;
	}
	
	/**
	 * 已领取的成就列表 achievement_reward
	 */
	private List<Integer> rewardList = new ArrayList<Integer>();

	/**
	 * 曾经获得的成就点
	 */
	private long achievementPoint;


	public List<Integer> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<Integer> rewardList) {
		this.rewardList = rewardList;
	}

	public long getAchievementPoint() {
		return achievementPoint;
	}

	public void setAchievementPoint(long achievementPoint) {
		this.achievementPoint = achievementPoint;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int rewardListLength = readShort(buf);
		for (int rewardListI = 0; rewardListI < rewardListLength; rewardListI++) {
			this.rewardList.add(this.readInt(buf, false));
		}

		this.achievementPoint = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.rewardList.size());
		for (int rewardListI = 0; rewardListI < this.rewardList.size(); rewardListI++) {
			this.writeInt(buf, this.rewardList.get(rewardListI), false);
		}

		this.writeLong(buf, achievementPoint);

		return true;
	}
}

