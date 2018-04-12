package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.duobao.msg.bean.RewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回抢夺结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRobResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRobResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48007;
	}
	
	/**
	 * 成功失败
	 */
	private boolean result;

	/**
	 * 奖励
	 */
	private List<RewardBean> rewardBeanList = new ArrayList<RewardBean>();


	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	
	public List<RewardBean> getRewardBeanList() {
		return rewardBeanList;
	}

	public void setRewardBeanList(List<RewardBean> rewardBeanList) {
		this.rewardBeanList = rewardBeanList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.result = readBoolean(buf);
		int rewardBeanListLength = readShort(buf);
		for (int rewardBeanListI = 0; rewardBeanListI < rewardBeanListLength; rewardBeanListI++) {
			if (readByte(buf) == 0) { 
				this.rewardBeanList.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.rewardBeanList.add(rewardBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBoolean(buf, result);
		writeShort(buf, this.rewardBeanList.size());
		for (int rewardBeanListI = 0; rewardBeanListI < this.rewardBeanList.size(); rewardBeanListI++) {
			this.writeBean(buf, this.rewardBeanList.get(rewardBeanListI));
		}


		return true;
	}
}

