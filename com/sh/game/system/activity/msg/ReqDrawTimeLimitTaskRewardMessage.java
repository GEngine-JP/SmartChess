package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>领取限时任务完成奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDrawTimeLimitTaskRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDrawTimeLimitTaskRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4025;
	}
	
	/**
	 * 倍数
	 */
	private int rate;
	/**
	 * 任务id
	 */
	private int taskId;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

		public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rate = readInt(buf, false);
		this.taskId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rate, false);
		this.writeInt(buf, taskId, false);
		return true;
	}
}
