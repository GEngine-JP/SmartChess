package com.sh.game.system.activity.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求打开经验炼制面板</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOpenLianZhiExpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenLianZhiExpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 4009;
	}
	
	/**
	 * 类型
	 */
	private int activityType;


	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.activityType = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activityType, false);

		return true;
	}
}

