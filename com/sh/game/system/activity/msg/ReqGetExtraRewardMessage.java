package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取限时任务额外奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetExtraRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetExtraRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4008;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;

	/**
	 * 当前第几轮
	 */
	private int goalType;


	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	public int getGoalType() {
		return goalType;
	}

	public void setGoalType(int goalType) {
		this.goalType = goalType;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.activityId = readInt(buf, false);
		this.goalType = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activityId, false);
		this.writeInt(buf, goalType, false);

		return true;
	}
}

