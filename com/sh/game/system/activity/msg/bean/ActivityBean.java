package com.sh.game.system.activity.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ActivityBean extends KryoBean {

	/**
	 * 活动id
	 */
	private int activityId;
	/**
	 * 目标数据
	 */
	private List<GoalBean> goalBean = new ArrayList<>();

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public List<GoalBean> getGoalBean() {
		return goalBean;
	}

	public void setGoalBean(List<GoalBean> goalBean) {
		this.goalBean = goalBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		int goalBeanLength = readShort(buf);
		for (int goalBeanI = 0; goalBeanI < goalBeanLength; goalBeanI++) {
			if (readByte(buf) == 0) { 
				this.goalBean.add(null);
			} else {
				GoalBean goalBean = new GoalBean();
				goalBean.read(buf);
				this.goalBean.add(goalBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		writeShort(buf, this.goalBean.size());
		for (int goalBeanI = 0; goalBeanI < this.goalBean.size(); goalBeanI++) {
			this.writeBean(buf, this.goalBean.get(goalBeanI));
		}
		return true;
	}
}
