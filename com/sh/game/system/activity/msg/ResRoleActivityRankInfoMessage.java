package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回玩家排行数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleActivityRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleActivityRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4028;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;
	/**
	 * 排行参数值
	 */
	private int rankParam;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

		public int getRankParam() {
		return rankParam;
	}

	public void setRankParam(int rankParam) {
		this.rankParam = rankParam;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		this.rankParam = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		this.writeInt(buf, rankParam, false);
		return true;
	}
}
