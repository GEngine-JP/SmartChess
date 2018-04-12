package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取首充奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqFirstRechargeRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFirstRechargeRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39003;
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

