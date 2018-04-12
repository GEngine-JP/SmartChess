package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送消费信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSpendInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSpendInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4018;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;

	/**
	 * 活动期间消费元宝数
	 */
	private int num;


	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.activityId = readInt(buf, false);
		this.num = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activityId, false);
		this.writeInt(buf, num, false);

		return true;
	}
}

