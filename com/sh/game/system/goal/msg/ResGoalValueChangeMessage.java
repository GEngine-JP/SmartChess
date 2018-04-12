package com.sh.game.system.goal.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>告诉客户端goal的数量变化了</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResGoalValueChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGoalValueChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 15001;
	}
	
	/**
	 * goalId
	 */
	private int goalId;

	/**
	 * goalCount
	 */
	private int goalCount;


	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	
	public int getGoalCount() {
		return goalCount;
	}

	public void setGoalCount(int goalCount) {
		this.goalCount = goalCount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.goalId = readInt(buf, false);
		this.goalCount = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, goalId, false);
		this.writeInt(buf, goalCount, false);

		return true;
	}
}

