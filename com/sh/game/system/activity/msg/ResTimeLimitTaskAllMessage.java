package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.activity.msg.bean.limitTimeTaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送限时任务信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTimeLimitTaskAllMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTimeLimitTaskAllMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4023;
	}
	
	/**
	 * 任务列表
	 */
	private List<limitTimeTaskBean> taskList = new ArrayList<>();

	public List<limitTimeTaskBean> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<limitTimeTaskBean> taskList) {
		this.taskList = taskList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int taskListLength = readShort(buf);
		for (int taskListI = 0; taskListI < taskListLength; taskListI++) {
			if (readByte(buf) == 0) { 
				this.taskList.add(null);
			} else {
				limitTimeTaskBean limitTimeTaskBean = new limitTimeTaskBean();
				limitTimeTaskBean.read(buf);
				this.taskList.add(limitTimeTaskBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.taskList.size());
		for (int taskListI = 0; taskListI < this.taskList.size(); taskListI++) {
			this.writeBean(buf, this.taskList.get(taskListI));
		}
		return true;
	}
}
