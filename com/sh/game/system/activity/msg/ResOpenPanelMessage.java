package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.activity.msg.bean.ActivityBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回活动面板数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResOpenPanelMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOpenPanelMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4004;
	}
	
	/**
	 * 组id
	 */
	private int groupId;

	/**
	 * 活动数据
	 */
	private List<ActivityBean> activityList = new ArrayList<ActivityBean>();


	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	
	public List<ActivityBean> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<ActivityBean> activityList) {
		this.activityList = activityList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.groupId = readInt(buf, false);
		int activityListLength = readShort(buf);
		for (int activityListI = 0; activityListI < activityListLength; activityListI++) {
			if (readByte(buf) == 0) { 
				this.activityList.add(null);
			} else {
				ActivityBean activityBean = new ActivityBean();
				activityBean.read(buf);
				this.activityList.add(activityBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, groupId, false);
		writeShort(buf, this.activityList.size());
		for (int activityListI = 0; activityListI < this.activityList.size(); activityListI++) {
			this.writeBean(buf, this.activityList.get(activityListI));
		}


		return true;
	}
}

