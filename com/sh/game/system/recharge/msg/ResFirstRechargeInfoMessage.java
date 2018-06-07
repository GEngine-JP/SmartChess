package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.recharge.msg.bean.FistRewardInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送首充奖励信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResFirstRechargeInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResFirstRechargeInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39004;
	}
	
	/**
	 * 每日充值信息
	 */
	private List<FistRewardInfo> rewardInfos = new ArrayList<>();

	public List<FistRewardInfo> getRewardInfos() {
		return rewardInfos;
	}

	public void setRewardInfos(List<FistRewardInfo> rewardInfos) {
		this.rewardInfos = rewardInfos;
	}

	@Override
	public boolean read(KryoInput buf) {

		int rewardInfosLength = readShort(buf);
		for (int rewardInfosI = 0; rewardInfosI < rewardInfosLength; rewardInfosI++) {
			if (readByte(buf) == 0) { 
				this.rewardInfos.add(null);
			} else {
				FistRewardInfo fistRewardInfo = new FistRewardInfo();
				fistRewardInfo.read(buf);
				this.rewardInfos.add(fistRewardInfo);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.rewardInfos.size());
		for (int rewardInfosI = 0; rewardInfosI < this.rewardInfos.size(); rewardInfosI++) {
			this.writeBean(buf, this.rewardInfos.get(rewardInfosI));
		}
		return true;
	}
}
