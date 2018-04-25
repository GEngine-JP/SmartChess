package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.task.msg.bean.TaskItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回精英任务面板消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendEliteInstancePanalInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEliteInstancePanalInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42001;
	}
	
	/**
	 * 精英任务表id
	 */
	private int cfgId;
	/**
	 * 副本id
	 */
	private int instanceId;
	/**
	 * 副本剩余次数
	 */
	private int remainCount;
	/**
	 * 精英任务当前星级
	 */
	private int starLevel;
	/**
	 * 奖励
	 */
	private List<TaskItemBean> rewards = new ArrayList<>();
	/**
	 * 任务状态0可接受1已接受2已完成
	 */
	private int taskState;
	/**
	 * 首次做任务0首次其他不是
	 */
	private int firstGet;

	public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

		public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getRemainCount() {
		return remainCount;
	}

	public void setRemainCount(int remainCount) {
		this.remainCount = remainCount;
	}

		public int getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}

		public List<TaskItemBean> getRewards() {
		return rewards;
	}

	public void setRewards(List<TaskItemBean> rewards) {
		this.rewards = rewards;
	}
	public int getTaskState() {
		return taskState;
	}

	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}

		public int getFirstGet() {
		return firstGet;
	}

	public void setFirstGet(int firstGet) {
		this.firstGet = firstGet;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cfgId = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.remainCount = readInt(buf, false);
		this.starLevel = readInt(buf, false);
		int rewardsLength = readShort(buf);
		for (int rewardsI = 0; rewardsI < rewardsLength; rewardsI++) {
			if (readByte(buf) == 0) { 
				this.rewards.add(null);
			} else {
				TaskItemBean taskItemBean = new TaskItemBean();
				taskItemBean.read(buf);
				this.rewards.add(taskItemBean);
			}
		}		this.taskState = readInt(buf, false);
		this.firstGet = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cfgId, false);
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, remainCount, false);
		this.writeInt(buf, starLevel, false);
		writeShort(buf, this.rewards.size());
		for (int rewardsI = 0; rewardsI < this.rewards.size(); rewardsI++) {
			this.writeBean(buf, this.rewards.get(rewardsI));
		}		this.writeInt(buf, taskState, false);
		this.writeInt(buf, firstGet, false);
		return true;
	}
}
