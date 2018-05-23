package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>更新限时任务进度</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResUpdateTimeLimitTaskProgressMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUpdateTimeLimitTaskProgressMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4024;
	}
	
	/**
	 * 任务id
	 */
	private int taskId;
	/**
	 * 完成次数
	 */
	private int count;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.taskId = readInt(buf, false);
		this.count = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, taskId, false);
		this.writeInt(buf, count, false);
		return true;
	}
}
