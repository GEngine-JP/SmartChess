package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回领取限时任务奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDrawLimitTaskRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDrawLimitTaskRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4026;
	}
	
	/**
	 * 任务id
	 */
	private int taskId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.taskId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, taskId, false);
		return true;
	}
}
