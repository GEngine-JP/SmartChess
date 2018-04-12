package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.robtreasure.msg.bean.LingBaoBean;
import com.sh.game.system.robtreasure.msg.bean.RewardBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回灵宝重生奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLingBaoRebirthRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLingBaoRebirthRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50026;
	}
	
	/**
	 * 返还的灵宝列表
	 */
	private List<LingBaoBean> lingBaoBean = new ArrayList<LingBaoBean>();

	/**
	 * 返还的道具列表
	 */
	private List<RewardBean> rewardList = new ArrayList<RewardBean>();


	public List<LingBaoBean> getLingBaoBean() {
		return lingBaoBean;
	}

	public void setLingBaoBean(List<LingBaoBean> lingBaoBean) {
		this.lingBaoBean = lingBaoBean;
	}

	public List<RewardBean> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<RewardBean> rewardList) {
		this.rewardList = rewardList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int lingBaoBeanLength = readShort(buf);
		for (int lingBaoBeanI = 0; lingBaoBeanI < lingBaoBeanLength; lingBaoBeanI++) {
			if (readByte(buf) == 0) { 
				this.lingBaoBean.add(null);
			} else {
				LingBaoBean lingBaoBean = new LingBaoBean();
				lingBaoBean.read(buf);
				this.lingBaoBean.add(lingBaoBean);
			}
		}

		int rewardListLength = readShort(buf);
		for (int rewardListI = 0; rewardListI < rewardListLength; rewardListI++) {
			if (readByte(buf) == 0) { 
				this.rewardList.add(null);
			} else {
				RewardBean rewardBean = new RewardBean();
				rewardBean.read(buf);
				this.rewardList.add(rewardBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.lingBaoBean.size());
		for (int lingBaoBeanI = 0; lingBaoBeanI < this.lingBaoBean.size(); lingBaoBeanI++) {
			this.writeBean(buf, this.lingBaoBean.get(lingBaoBeanI));
		}

		writeShort(buf, this.rewardList.size());
		for (int rewardListI = 0; rewardListI < this.rewardList.size(); rewardListI++) {
			this.writeBean(buf, this.rewardList.get(rewardListI));
		}


		return true;
	}
}

