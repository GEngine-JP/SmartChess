package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送累计充值天数</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLeijiRechargeDaysMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLeijiRechargeDaysMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4013;
	}
	
	/**
	 * 累计充值天数
	 */
	private int days;
	/**
	 * 活动Id
	 */
	private int activityId;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

		public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.days = readInt(buf, false);
		this.activityId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, days, false);
		this.writeInt(buf, activityId, false);
		return true;
	}
}
