package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.ladder.msg.bean.LadderRankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回天梯排行榜</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLadderRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLadderRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5005;
	}
	
	/**
	 * 领取状态  1可领 2已领
	 */
	private int rewardState;
	/**
	 * 当前赛季
	 */
	private int week;
	/**
	 * 天梯排行榜数据
	 */
	private List<LadderRankBean> ladderRankBean = new ArrayList<>();

	public int getRewardState() {
		return rewardState;
	}

	public void setRewardState(int rewardState) {
		this.rewardState = rewardState;
	}

		public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

		public List<LadderRankBean> getLadderRankBean() {
		return ladderRankBean;
	}

	public void setLadderRankBean(List<LadderRankBean> ladderRankBean) {
		this.ladderRankBean = ladderRankBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.rewardState = readInt(buf, false);
		this.week = readInt(buf, false);
		int ladderRankBeanLength = readShort(buf);
		for (int ladderRankBeanI = 0; ladderRankBeanI < ladderRankBeanLength; ladderRankBeanI++) {
			if (readByte(buf) == 0) { 
				this.ladderRankBean.add(null);
			} else {
				LadderRankBean ladderRankBean = new LadderRankBean();
				ladderRankBean.read(buf);
				this.ladderRankBean.add(ladderRankBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rewardState, false);
		this.writeInt(buf, week, false);
		writeShort(buf, this.ladderRankBean.size());
		for (int ladderRankBeanI = 0; ladderRankBeanI < this.ladderRankBean.size(); ladderRankBeanI++) {
			this.writeBean(buf, this.ladderRankBean.get(ladderRankBeanI));
		}
		return true;
	}
}
