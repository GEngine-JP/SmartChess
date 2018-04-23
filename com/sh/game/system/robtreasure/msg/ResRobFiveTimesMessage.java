package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.FakeRewardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回夺五次结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRobFiveTimesMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRobFiveTimesMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50009;
	}
	
	/**
	 * 奖励
	 */
	private List<FakeRewardBean> rewardBeanList = new ArrayList<>();
	/**
	 * 是否是夺五次
	 */
	private int isFive;

	public List<FakeRewardBean> getRewardBeanList() {
		return rewardBeanList;
	}

	public void setRewardBeanList(List<FakeRewardBean> rewardBeanList) {
		this.rewardBeanList = rewardBeanList;
	}
	public int getIsFive() {
		return isFive;
	}

	public void setIsFive(int isFive) {
		this.isFive = isFive;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int rewardBeanListLength = readShort(buf);
		for (int rewardBeanListI = 0; rewardBeanListI < rewardBeanListLength; rewardBeanListI++) {
			if (readByte(buf) == 0) { 
				this.rewardBeanList.add(null);
			} else {
				FakeRewardBean fakeRewardBean = new FakeRewardBean();
				fakeRewardBean.read(buf);
				this.rewardBeanList.add(fakeRewardBean);
			}
		}		this.isFive = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rewardBeanList.size());
		for (int rewardBeanListI = 0; rewardBeanListI < this.rewardBeanList.size(); rewardBeanListI++) {
			this.writeBean(buf, this.rewardBeanList.get(rewardBeanListI));
		}		this.writeInt(buf, isFive, false);
		return true;
	}
}
