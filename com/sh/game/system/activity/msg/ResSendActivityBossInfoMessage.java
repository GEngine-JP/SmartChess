package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送活动boss信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendActivityBossInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendActivityBossInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4014;
	}
	
	/**
	 * 剩余次数
	 */
	private int remainNum;

	/**
	 * 已购买次数
	 */
	private int hasBuyNum;

	/**
	 * 活动id
	 */
	private int activityId;


	public int getRemainNum() {
		return remainNum;
	}

	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

	
	public int getHasBuyNum() {
		return hasBuyNum;
	}

	public void setHasBuyNum(int hasBuyNum) {
		this.hasBuyNum = hasBuyNum;
	}

	
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.remainNum = readInt(buf, false);
		this.hasBuyNum = readInt(buf, false);
		this.activityId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, remainNum, false);
		this.writeInt(buf, hasBuyNum, false);
		this.writeInt(buf, activityId, false);

		return true;
	}
}

