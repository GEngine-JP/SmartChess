package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.instance.msg.bean.FirePigInfo;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>烧猪副本结算面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendFirePigRewardPanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendFirePigRewardPanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20029;
	}
	
	/**
	 * 奖励信息
	 */
	private List<FirePigInfo> rewardInfo = new ArrayList<FirePigInfo>();


	public List<FirePigInfo> getRewardInfo() {
		return rewardInfo;
	}

	public void setRewardInfo(List<FirePigInfo> rewardInfo) {
		this.rewardInfo = rewardInfo;
	}


	@Override
	public boolean read(KryoInput buf) {
		int rewardInfoLength = readShort(buf);
		for (int rewardInfoI = 0; rewardInfoI < rewardInfoLength; rewardInfoI++) {
			if (readByte(buf) == 0) { 
				this.rewardInfo.add(null);
			} else {
				FirePigInfo firePigInfo = new FirePigInfo();
				firePigInfo.read(buf);
				this.rewardInfo.add(firePigInfo);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.rewardInfo.size());
		for (int rewardInfoI = 0; rewardInfoI < this.rewardInfo.size(); rewardInfoI++) {
			this.writeBean(buf, this.rewardInfo.get(rewardInfoI));
		}


		return true;
	}
}

