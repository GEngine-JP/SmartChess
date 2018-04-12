package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求每日结算排行信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqArenaRankDailyInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqArenaRankDailyInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37016;
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

