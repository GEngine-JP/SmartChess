package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送带目标的活动数据改变</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResActivityDataChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResActivityDataChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4012;
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
	 * 组id
	 */
	private int group;

	/**
	 * 目标参数
	 */
	private int goal;

	/**
	 * 状态
	 */
	private int state;

	/**
	 * 当前进度
	 */
	private int now;

	/**
	 * 总进度
	 */
	private int total;


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

	
	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	
	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}

	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.activityId = readInt(buf, false);
		this.type = readInt(buf, false);
		this.group = readInt(buf, false);
		this.goal = readInt(buf, false);
		this.state = readInt(buf, false);
		this.now = readInt(buf, false);
		this.total = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activityId, false);
		this.writeInt(buf, type, false);
		this.writeInt(buf, group, false);
		this.writeInt(buf, goal, false);
		this.writeInt(buf, state, false);
		this.writeInt(buf, now, false);
		this.writeInt(buf, total, false);

		return true;
	}
}

