package com.sh.game.system.logingift.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>奖励信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLoginGiftInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLoginGiftInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 2002;
	}
	
	/**
	 * 配置表id
	 */
	private int loginDay;

	/**
	 * 已领过的列表
	 */
	private List<Integer> rewardList = new ArrayList<Integer>();


	public int getLoginDay() {
		return loginDay;
	}

	public void setLoginDay(int loginDay) {
		this.loginDay = loginDay;
	}

	
	public List<Integer> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<Integer> rewardList) {
		this.rewardList = rewardList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.loginDay = readInt(buf, false);
		int rewardListLength = readShort(buf);
		for (int rewardListI = 0; rewardListI < rewardListLength; rewardListI++) {
			this.rewardList.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, loginDay, false);
		writeShort(buf, this.rewardList.size());
		for (int rewardListI = 0; rewardListI < this.rewardList.size(); rewardListI++) {
			this.writeInt(buf, this.rewardList.get(rewardListI), false);
		}


		return true;
	}
}

