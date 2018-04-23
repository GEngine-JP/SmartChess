package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取活动奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetActivityRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetActivityRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4001;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;
	/**
	 * 目标类型
	 */
	private int type;
	/**
	 * 目标参数
	 */
	private int goal;
	/**
	 * 多倍领取倍数
	 */
	private int multi;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

		public int getMulti() {
		return multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		this.type = readInt(buf, false);
		this.goal = readInt(buf, false);
		this.multi = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		this.writeInt(buf, type, false);
		this.writeInt(buf, goal, false);
		this.writeInt(buf, multi, false);
		return true;
	}
}
