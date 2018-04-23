package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送财富幸运儿信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLuckTreasureMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLuckTreasureMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4016;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;
	/**
	 * 第几天
	 */
	private int day;
	/**
	 * 开奖状态 0开奖前 1开奖后
	 */
	private int openState;
	/**
	 * 获奖者
	 */
	private String luckyName;
	/**
	 * 幸运号码
	 */
	private int luckyNum;
	/**
	 * 幸运数字
	 */
	private List<Integer> luckNumberList = new ArrayList<>();

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

		public int getOpenState() {
		return openState;
	}

	public void setOpenState(int openState) {
		this.openState = openState;
	}

		public String getLuckyName() {
		return luckyName;
	}

	public void setLuckyName(String luckyName) {
		this.luckyName = luckyName;
	}

		public int getLuckyNum() {
		return luckyNum;
	}

	public void setLuckyNum(int luckyNum) {
		this.luckyNum = luckyNum;
	}

		public List<Integer> getLuckNumberList() {
		return luckNumberList;
	}

	public void setLuckNumberList(List<Integer> luckNumberList) {
		this.luckNumberList = luckNumberList;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		this.day = readInt(buf, false);
		this.openState = readInt(buf, false);
		this.luckyName = readString(buf);
		this.luckyNum = readInt(buf, false);
		int luckNumberListLength = readShort(buf);
		for (int luckNumberListI = 0; luckNumberListI < luckNumberListLength; luckNumberListI++) {
			this.luckNumberList.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		this.writeInt(buf, day, false);
		this.writeInt(buf, openState, false);
		this.writeString(buf, luckyName);
		this.writeInt(buf, luckyNum, false);
		writeShort(buf, this.luckNumberList.size());
		for (int luckNumberListI = 0; luckNumberListI < this.luckNumberList.size(); luckNumberListI++) {
			this.writeInt(buf, this.luckNumberList.get(luckNumberListI), false);
		}
		return true;
	}
}
