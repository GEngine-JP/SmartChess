package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.activity.msg.bean.FirstKillRewardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送首杀boss信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendFirstKillBossMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendFirstKillBossMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4021;
	}
	
	/**
	 * 奖励信息
	 */
	private List<FirstKillRewardBean> rewardBeans = new ArrayList<>();
	/**
	 * activityId
	 */
	private int activityId;

	public List<FirstKillRewardBean> getRewardBeans() {
		return rewardBeans;
	}

	public void setRewardBeans(List<FirstKillRewardBean> rewardBeans) {
		this.rewardBeans = rewardBeans;
	}
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int rewardBeansLength = readShort(buf);
		for (int rewardBeansI = 0; rewardBeansI < rewardBeansLength; rewardBeansI++) {
			if (readByte(buf) == 0) { 
				this.rewardBeans.add(null);
			} else {
				FirstKillRewardBean firstKillRewardBean = new FirstKillRewardBean();
				firstKillRewardBean.read(buf);
				this.rewardBeans.add(firstKillRewardBean);
			}
		}		this.activityId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rewardBeans.size());
		for (int rewardBeansI = 0; rewardBeansI < this.rewardBeans.size(); rewardBeansI++) {
			this.writeBean(buf, this.rewardBeans.get(rewardBeansI));
		}		this.writeInt(buf, activityId, false);
		return true;
	}
}
