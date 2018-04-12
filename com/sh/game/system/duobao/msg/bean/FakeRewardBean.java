package com.sh.game.system.duobao.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.duobao.msg.bean.RewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class FakeRewardBean extends KryoBean {

	/**
	 * 成功失败
	 */
	private boolean result;

	/**
	 * 奖励
	 */
	private List<RewardBean> reward = new ArrayList<RewardBean>();


	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	
	public List<RewardBean> getReward() {
		return reward;
	}

	public void setReward(List<RewardBean> reward) {
		this.reward = reward;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.result = readBoolean(buf);
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
		this.writeBoolean(buf, result);
		writeShort(buf, this.reward.size());
		for (int rewardI = 0; rewardI < this.reward.size(); rewardI++) {
			this.writeBean(buf, this.reward.get(rewardI));
		}


		return true;
	}
}

