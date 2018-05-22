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

public class FirstKillBean extends KryoBean {

	/**
	 * goals表id
	 */
	private int goalId;
	/**
	 * 对应副本id
	 */
	private int instanceId;
	/**
	 * 击杀状态0未击杀1存活
	 */
	private int state;

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

		public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.goalId = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.state = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, goalId, false);
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, state, false);
		return true;
	}
}
