package com.sh.game.system.activity.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class limitTimeTaskBean extends KryoBean {

	/**
	 * 任务id
	 */
	private int taskId;
	/**
	 * 完成进度
	 */
	private int value;
	/**
	 * 状态 1 未完成 2 已完成 3 已领奖
	 */
	private int state;
	/**
	 * 结束时间(s)
	 */
	private int endTime;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

		public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.taskId = readInt(buf, false);
		this.value = readInt(buf, false);
		this.state = readInt(buf, false);
		this.endTime = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, taskId, false);
		this.writeInt(buf, value, false);
		this.writeInt(buf, state, false);
		this.writeInt(buf, endTime, false);
		return true;
	}
}
