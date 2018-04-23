package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.official.msg.bean.DailyTaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送官职界面信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResOfficialInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResOfficialInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56001;
	}
	
	/**
	 * 职级
	 */
	private int officialGrade;
	/**
	 * 历练点
	 */
	private int totalPoint;
	/**
	 * 日活跃点
	 */
	private int dailyPoint;
	/**
	 * 每日活跃奖励已领列表
	 */
	private List<Integer> dailyRewardDrawList = new ArrayList<>();
	/**
	 * 每日活跃任务列表
	 */
	private List<DailyTaskBean> dailyTaskInfoList = new ArrayList<>();

	public int getOfficialGrade() {
		return officialGrade;
	}

	public void setOfficialGrade(int officialGrade) {
		this.officialGrade = officialGrade;
	}

		public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

		public int getDailyPoint() {
		return dailyPoint;
	}

	public void setDailyPoint(int dailyPoint) {
		this.dailyPoint = dailyPoint;
	}

		public List<Integer> getDailyRewardDrawList() {
		return dailyRewardDrawList;
	}

	public void setDailyRewardDrawList(List<Integer> dailyRewardDrawList) {
		this.dailyRewardDrawList = dailyRewardDrawList;
	}
	public List<DailyTaskBean> getDailyTaskInfoList() {
		return dailyTaskInfoList;
	}

	public void setDailyTaskInfoList(List<DailyTaskBean> dailyTaskInfoList) {
		this.dailyTaskInfoList = dailyTaskInfoList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.officialGrade = readInt(buf, false);
		this.totalPoint = readInt(buf, false);
		this.dailyPoint = readInt(buf, false);
		int dailyRewardDrawListLength = readShort(buf);
		for (int dailyRewardDrawListI = 0; dailyRewardDrawListI < dailyRewardDrawListLength; dailyRewardDrawListI++) {
			this.dailyRewardDrawList.add(this.readInt(buf, false));
		}		int dailyTaskInfoListLength = readShort(buf);
		for (int dailyTaskInfoListI = 0; dailyTaskInfoListI < dailyTaskInfoListLength; dailyTaskInfoListI++) {
			if (readByte(buf) == 0) { 
				this.dailyTaskInfoList.add(null);
			} else {
				DailyTaskBean dailyTaskBean = new DailyTaskBean();
				dailyTaskBean.read(buf);
				this.dailyTaskInfoList.add(dailyTaskBean);
			}
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, officialGrade, false);
		this.writeInt(buf, totalPoint, false);
		this.writeInt(buf, dailyPoint, false);
		writeShort(buf, this.dailyRewardDrawList.size());
		for (int dailyRewardDrawListI = 0; dailyRewardDrawListI < this.dailyRewardDrawList.size(); dailyRewardDrawListI++) {
			this.writeInt(buf, this.dailyRewardDrawList.get(dailyRewardDrawListI), false);
		}		writeShort(buf, this.dailyTaskInfoList.size());
		for (int dailyTaskInfoListI = 0; dailyTaskInfoListI < this.dailyTaskInfoList.size(); dailyTaskInfoListI++) {
			this.writeBean(buf, this.dailyTaskInfoList.get(dailyTaskInfoListI));
		}
		return true;
	}
}
