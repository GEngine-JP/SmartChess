package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回每周充值累计数量</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResWeekTotalRechargeNumMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResWeekTotalRechargeNumMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4006;
	}
	
	/**
	 * 累计数量
	 */
	private int totalNum;
	/**
	 * 活动Id
	 */
	private int activityId;

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

		public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.totalNum = readInt(buf, false);
		this.activityId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, totalNum, false);
		this.writeInt(buf, activityId, false);
		return true;
	}
}
