package com.sh.game.system.achievement.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求每日活跃值</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDailyActivePointMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDailyActivePointMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 17010;
	}
	


	@Override
	public boolean read(KryoInput buf) {


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {


		return true;
	}
}
