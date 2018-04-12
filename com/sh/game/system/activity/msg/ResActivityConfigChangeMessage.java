package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送活动配置改变</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResActivityConfigChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResActivityConfigChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4015;
	}
	
	/**
	 * activityChange
	 */
	private List<String> changedActivityList = new ArrayList<String>();

	/**
	 * activityGoalChange
	 */
	private List<String> changedGoalList = new ArrayList<String>();


	public List<String> getChangedActivityList() {
		return changedActivityList;
	}

	public void setChangedActivityList(List<String> changedActivityList) {
		this.changedActivityList = changedActivityList;
	}

	public List<String> getChangedGoalList() {
		return changedGoalList;
	}

	public void setChangedGoalList(List<String> changedGoalList) {
		this.changedGoalList = changedGoalList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int changedActivityListLength = readShort(buf);
		for (int changedActivityListI = 0; changedActivityListI < changedActivityListLength; changedActivityListI++) {
			this.changedActivityList.add(this.readString(buf));
		}

		int changedGoalListLength = readShort(buf);
		for (int changedGoalListI = 0; changedGoalListI < changedGoalListLength; changedGoalListI++) {
			this.changedGoalList.add(this.readString(buf));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.changedActivityList.size());
		for (int changedActivityListI = 0; changedActivityListI < this.changedActivityList.size(); changedActivityListI++) {
			this.writeString(buf, this.changedActivityList.get(changedActivityListI));
		}

		writeShort(buf, this.changedGoalList.size());
		for (int changedGoalListI = 0; changedGoalListI < this.changedGoalList.size(); changedGoalListI++) {
			this.writeString(buf, this.changedGoalList.get(changedGoalListI));
		}


		return true;
	}
}

