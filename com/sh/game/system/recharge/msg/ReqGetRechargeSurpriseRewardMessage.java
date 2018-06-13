package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取充值惊喜奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetRechargeSurpriseRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetRechargeSurpriseRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39009;
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
