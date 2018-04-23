package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.official.msg.bean.DailyTaskBean;

/**
 * <p>发送完成任务数量变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTaskCompletedCountChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTaskCompletedCountChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56008;
	}
	
	/**
	 * 任务信息
	 */
	private DailyTaskBean taskInfo;

	public DailyTaskBean getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(DailyTaskBean taskInfo) {
		this.taskInfo = taskInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			DailyTaskBean dailyTaskBean = new DailyTaskBean();
			dailyTaskBean.read(buf);
			this.taskInfo = dailyTaskBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, taskInfo);
		return true;
	}
}
