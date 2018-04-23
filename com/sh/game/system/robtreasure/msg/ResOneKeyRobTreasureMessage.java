package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.RewardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回一键夺宝结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOneKeyRobTreasureMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOneKeyRobTreasureMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50011;
	}
	
	/**
	 * 成功1失败0
	 */
	private int result;
	/**
	 * 夺宝次数
	 */
	private int count;
	/**
	 * 使用精力丹个数
	 */
	private int energyDanNum;
	/**
	 * 基础奖励
	 */
	private List<RewardBean> basicReward = new ArrayList<>();
	/**
	 * 奖励
	 */
	private List<RewardBean> rewardList = new ArrayList<>();

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

		public int getEnergyDanNum() {
		return energyDanNum;
	}

	public void setEnergyDanNum(int energyDanNum) {
		this.energyDanNum = energyDanNum;
	}

		public List<RewardBean> getBasicReward() {
		return basicReward;
	}

	public void setBasicReward(List<RewardBean> basicReward) {
		this.basicReward = basicReward;
	}
	public List<RewardBean> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<RewardBean> rewardList) {
		this.rewardList = rewardList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.result = readInt(buf, false);
		this.count = readInt(buf, false);
		this.energyDanNum = readInt(buf, false);
		int basicRewardLength = readShort(buf);
		for (int basicRewardI = 0; basicRewardI < basicRewardLength; basicRewardI++) {
			if (readByte(buf) == 0) { 
				this.basicReward.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.basicReward.add(rewardBean);
			}
		}		int rewardListLength = readShort(buf);
		for (int rewardListI = 0; rewardListI < rewardListLength; rewardListI++) {
			if (readByte(buf) == 0) { 
				this.rewardList.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.rewardList.add(rewardBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, result, false);
		this.writeInt(buf, count, false);
		this.writeInt(buf, energyDanNum, false);
		writeShort(buf, this.basicReward.size());
		for (int basicRewardI = 0; basicRewardI < this.basicReward.size(); basicRewardI++) {
			this.writeBean(buf, this.basicReward.get(basicRewardI));
		}		writeShort(buf, this.rewardList.size());
		for (int rewardListI = 0; rewardListI < this.rewardList.size(); rewardListI++) {
			this.writeBean(buf, this.rewardList.get(rewardListI));
		}
		return true;
	}
}
