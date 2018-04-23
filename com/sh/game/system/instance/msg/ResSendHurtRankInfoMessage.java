package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.instance.msg.bean.HurtRankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送伤害排行变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendHurtRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendHurtRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20009;
	}
	
	/**
	 * 前端显示的排名
	 */
	private List<HurtRankBean> ranks = new ArrayList<>();
	/**
	 * 自已的排名
	 */
	private HurtRankBean selfRank;

	public List<HurtRankBean> getRanks() {
		return ranks;
	}

	public void setRanks(List<HurtRankBean> ranks) {
		this.ranks = ranks;
	}
	public HurtRankBean getSelfRank() {
		return selfRank;
	}

	public void setSelfRank(HurtRankBean selfRank) {
		this.selfRank = selfRank;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int ranksLength = readShort(buf);
		for (int ranksI = 0; ranksI < ranksLength; ranksI++) {
			if (readByte(buf) == 0) { 
				this.ranks.add(null);
			} else {
				HurtRankBean hurtRankBean = new HurtRankBean();
				hurtRankBean.read(buf);
				this.ranks.add(hurtRankBean);
			}
		}		if (readByte(buf) != 0) {
			HurtRankBean hurtRankBean = new HurtRankBean();
			hurtRankBean.read(buf);
			this.selfRank = hurtRankBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.ranks.size());
		for (int ranksI = 0; ranksI < this.ranks.size(); ranksI++) {
			this.writeBean(buf, this.ranks.get(ranksI));
		}		this.writeBean(buf, selfRank);
		return true;
	}
}
