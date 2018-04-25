package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送通天塔面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleTowerInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleTowerInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54001;
	}
	
	/**
	 * 重天
	 */
	private int group;
	/**
	 * 层数
	 */
	private int storey;
	/**
	 * 转盘次数
	 */
	private int times;
	/**
	 * 每日奖励领奖状态 0不可领奖 1可领取 2已领取
	 */
	private int rewardState;

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

		public int getStorey() {
		return storey;
	}

	public void setStorey(int storey) {
		this.storey = storey;
	}

		public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

		public int getRewardState() {
		return rewardState;
	}

	public void setRewardState(int rewardState) {
		this.rewardState = rewardState;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.group = readInt(buf, false);
		this.storey = readInt(buf, false);
		this.times = readInt(buf, false);
		this.rewardState = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, group, false);
		this.writeInt(buf, storey, false);
		this.writeInt(buf, times, false);
		this.writeInt(buf, rewardState, false);
		return true;
	}
}
