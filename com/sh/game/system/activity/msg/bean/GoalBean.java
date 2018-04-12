package com.sh.game.system.activity.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class GoalBean extends KryoBean {

	/**
	 * 目标类型
	 */
	private int goalType;

	/**
	 * 目标id
	 */
	private int goal;

	/**
	 * 是否领取过:0未领取 1可领取 2已领取
	 */
	private int rewardState;

	/**
	 * 剩余可领个数
	 */
	private int leftCount;

	/**
	 * 当前进度
	 */
	private int now;

	/**
	 * 总进度
	 */
	private int total;


	public int getGoalType() {
		return goalType;
	}

	public void setGoalType(int goalType) {
		this.goalType = goalType;
	}

	
	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	
	public int getRewardState() {
		return rewardState;
	}

	public void setRewardState(int rewardState) {
		this.rewardState = rewardState;
	}

	
	public int getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(int leftCount) {
		this.leftCount = leftCount;
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
		this.goalType = readInt(buf, false);
		this.goal = readInt(buf, false);
		this.rewardState = readInt(buf, false);
		this.leftCount = readInt(buf, false);
		this.now = readInt(buf, false);
		this.total = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, goalType, false);
		this.writeInt(buf, goal, false);
		this.writeInt(buf, rewardState, false);
		this.writeInt(buf, leftCount, false);
		this.writeInt(buf, now, false);
		this.writeInt(buf, total, false);

		return true;
	}
}

