package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>推送每日活跃值</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResDailyActivePointMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDailyActivePointMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17011;
	}
	
	/**
	 * 每日活跃值
	 */
	private int dailyActivePoint;


	public int getDailyActivePoint() {
		return dailyActivePoint;
	}

	public void setDailyActivePoint(int dailyActivePoint) {
		this.dailyActivePoint = dailyActivePoint;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.dailyActivePoint = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, dailyActivePoint, false);

		return true;
	}
}

