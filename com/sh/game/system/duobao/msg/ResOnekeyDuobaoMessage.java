package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.duobao.msg.bean.RewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回一键夺宝结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResOnekeyDuobaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOnekeyDuobaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48011;
	}
	
	/**
	 * 成功失败
	 */
	private boolean result;

	/**
	 * 夺宝次数
	 */
	private int count;

	/**
	 * 使用精力丹个数
	 */
	private int jingliDan;

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

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public int getJingliDan() {
		return jingliDan;
	}

	public void setJingliDan(int jingliDan) {
		this.jingliDan = jingliDan;
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
		this.count = readInt(buf, false);
		this.jingliDan = readInt(buf, false);
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
		this.writeInt(buf, count, false);
		this.writeInt(buf, jingliDan, false);
		writeShort(buf, this.rewardBeanList.size());
		for (int rewardBeanListI = 0; rewardBeanListI < this.rewardBeanList.size(); rewardBeanListI++) {
			this.writeBean(buf, this.rewardBeanList.get(rewardBeanListI));
		}


		return true;
	}
}

