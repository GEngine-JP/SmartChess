package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求玩家排行数据</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRoleActivityRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRoleActivityRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4027;
	}
	
	/**
	 * 活动id
	 */
	private int activityId;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.activityId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, activityId, false);
		return true;
	}
}
