package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.shobak.msg.bean.LeaderInfoBean;

/**
 * <p>返回膜拜面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendWorshipPanelInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendWorshipPanelInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40004;
	}
	
	/**
	 * 领取状态0未领取 1已领取 2不可领取
	 */
	private int state;
	/**
	 * 霸主会长信息
	 */
	private LeaderInfoBean leaderBean;
	/**
	 * 下次争霸开启时间
	 */
	private int nextStartTime;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public LeaderInfoBean getLeaderBean() {
		return leaderBean;
	}

	public void setLeaderBean(LeaderInfoBean leaderBean) {
		this.leaderBean = leaderBean;
	}

		public int getNextStartTime() {
		return nextStartTime;
	}

	public void setNextStartTime(int nextStartTime) {
		this.nextStartTime = nextStartTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.state = readInt(buf, false);
		if (readByte(buf) != 0) {
			LeaderInfoBean leaderInfoBean = new LeaderInfoBean();
			leaderInfoBean.read(buf);
			this.leaderBean = leaderInfoBean;
		}
		this.nextStartTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, state, false);
		this.writeBean(buf, leaderBean);
		this.writeInt(buf, nextStartTime, false);
		return true;
	}
}
