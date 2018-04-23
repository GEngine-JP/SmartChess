package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送日活跃点</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDailyPointChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDailyPointChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56007;
	}
	
	/**
	 * 日活跃点
	 */
	private int dailyPoint;

	public int getDailyPoint() {
		return dailyPoint;
	}

	public void setDailyPoint(int dailyPoint) {
		this.dailyPoint = dailyPoint;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.dailyPoint = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, dailyPoint, false);
		return true;
	}
}
