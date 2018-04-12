package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回限时任务额外奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResExtraRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResExtraRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4007;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;

	/**
	 * 剩余时间
	 */
	private int time;

	/**
	 * 当前第几轮
	 */
	private int goalType;

	/**
	 * 奖励领取状态
	 */
	private int state;


	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	public int getGoalType() {
		return goalType;
	}

	public void setGoalType(int goalType) {
		this.goalType = goalType;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.activityId = readInt(buf, false);
		this.time = readInt(buf, false);
		this.goalType = readInt(buf, false);
		this.state = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activityId, false);
		this.writeInt(buf, time, false);
		this.writeInt(buf, goalType, false);
		this.writeInt(buf, state, false);

		return true;
	}
}

