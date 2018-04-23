package com.sh.game.system.activity.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ActivityRankBean extends KryoBean {

	/**
	 * activityId
	 */
	private int activityId;
	/**
	 * 排名第一玩家的模型
	 */
	private FirstRoleBean firstRoleBean;
	/**
	 * 排行榜数据
	 */
	private List<RankInfoBean> rankInfoList = new ArrayList<>();

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public FirstRoleBean getFirstRoleBean() {
		return firstRoleBean;
	}

	public void setFirstRoleBean(FirstRoleBean firstRoleBean) {
		this.firstRoleBean = firstRoleBean;
	}

		public List<RankInfoBean> getRankInfoList() {
		return rankInfoList;
	}

	public void setRankInfoList(List<RankInfoBean> rankInfoList) {
		this.rankInfoList = rankInfoList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		if (readByte(buf) != 0) {
			FirstRoleBean firstRoleBean = new FirstRoleBean();
			firstRoleBean.read(buf);
			this.firstRoleBean = firstRoleBean;
		}
		int rankInfoListLength = readShort(buf);
		for (int rankInfoListI = 0; rankInfoListI < rankInfoListLength; rankInfoListI++) {
			if (readByte(buf) == 0) { 
				this.rankInfoList.add(null);
			} else {
				RankInfoBean rankInfoBean = new RankInfoBean();
				rankInfoBean.read(buf);
				this.rankInfoList.add(rankInfoBean);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		this.writeBean(buf, firstRoleBean);
		writeShort(buf, this.rankInfoList.size());
		for (int rankInfoListI = 0; rankInfoListI < this.rankInfoList.size(); rankInfoListI++) {
			this.writeBean(buf, this.rankInfoList.get(rankInfoListI));
		}
		return true;
	}
}
