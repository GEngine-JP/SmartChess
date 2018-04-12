package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求王者禁地每周奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetKingForbiddenWeekRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetKingForbiddenWeekRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45005;
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

