package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.activity.msg.bean.ActivityRankBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回排行榜类型活动数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRankActivityMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRankActivityMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4005;
	}
	
	/**
	 * groupId
	 */
	private int groupId;

	/**
	 * 活动数据
	 */
	private List<ActivityRankBean> rankInfoBeanList = new ArrayList<ActivityRankBean>();


	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	
	public List<ActivityRankBean> getRankInfoBeanList() {
		return rankInfoBeanList;
	}

	public void setRankInfoBeanList(List<ActivityRankBean> rankInfoBeanList) {
		this.rankInfoBeanList = rankInfoBeanList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.groupId = readInt(buf, false);
		int rankInfoBeanListLength = readShort(buf);
		for (int rankInfoBeanListI = 0; rankInfoBeanListI < rankInfoBeanListLength; rankInfoBeanListI++) {
			if (readByte(buf) == 0) { 
				this.rankInfoBeanList.add(null);
			} else {
				ActivityRankBean activityRankBean = new ActivityRankBean();
				activityRankBean.read(buf);
				this.rankInfoBeanList.add(activityRankBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, groupId, false);
		writeShort(buf, this.rankInfoBeanList.size());
		for (int rankInfoBeanListI = 0; rankInfoBeanListI < this.rankInfoBeanList.size(); rankInfoBeanListI++) {
			this.writeBean(buf, this.rankInfoBeanList.get(rankInfoBeanListI));
		}


		return true;
	}
}

