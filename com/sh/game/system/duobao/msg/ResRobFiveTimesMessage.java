package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.duobao.msg.bean.FakeRewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回夺五次结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
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
		return 48009;
	}
	
	/**
	 * 奖励
	 */
	private List<FakeRewardBean> rewardBeanList = new ArrayList<FakeRewardBean>();


	public List<FakeRewardBean> getRewardBeanList() {
		return rewardBeanList;
	}

	public void setRewardBeanList(List<FakeRewardBean> rewardBeanList) {
		this.rewardBeanList = rewardBeanList;
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
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.rewardBeanList.size());
		for (int rewardBeanListI = 0; rewardBeanListI < this.rewardBeanList.size(); rewardBeanListI++) {
			this.writeBean(buf, this.rewardBeanList.get(rewardBeanListI));
		}


		return true;
	}
}

