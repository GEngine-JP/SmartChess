package com.sh.game.system.robtreasure.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.robtreasure.msg.bean.RewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class FakeRewardBean extends KryoBean {

	/**
	 * 副本成功1失败0
	 */
	private int instanceResult;

	/**
	 * 成功1失败0
	 */
	private int result;

	/**
	 * 基本奖励
	 */
	private List<RewardBean> basicReward = new ArrayList<RewardBean>();

	/**
	 * 奖励
	 */
	private List<RewardBean> reward = new ArrayList<RewardBean>();


	public int getInstanceResult() {
		return instanceResult;
	}

	public void setInstanceResult(int instanceResult) {
		this.instanceResult = instanceResult;
	}

	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	
	public List<RewardBean> getBasicReward() {
		return basicReward;
	}

	public void setBasicReward(List<RewardBean> basicReward) {
		this.basicReward = basicReward;
	}

	public List<RewardBean> getReward() {
		return reward;
	}

	public void setReward(List<RewardBean> reward) {
		this.reward = reward;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.instanceResult = readInt(buf, false);
		this.result = readInt(buf, false);
		int basicRewardLength = readShort(buf);
		for (int basicRewardI = 0; basicRewardI < basicRewardLength; basicRewardI++) {
			if (readByte(buf) == 0) { 
				this.basicReward.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.basicReward.add(rewardBean);
			}
		}

		int rewardLength = readShort(buf);
		for (int rewardI = 0; rewardI < rewardLength; rewardI++) {
			if (readByte(buf) == 0) { 
				this.reward.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.reward.add(rewardBean);
			}
		}


		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, instanceResult, false);
		this.writeInt(buf, result, false);
		writeShort(buf, this.basicReward.size());
		for (int basicRewardI = 0; basicRewardI < this.basicReward.size(); basicRewardI++) {
			this.writeBean(buf, this.basicReward.get(basicRewardI));
		}

		writeShort(buf, this.reward.size());
		for (int rewardI = 0; rewardI < this.reward.size(); rewardI++) {
			this.writeBean(buf, this.reward.get(rewardI));
		}


		return true;
	}
}

