package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求行会挑战通关奖励信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUnionChallengeCrossRewardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUnionChallengeCrossRewardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23048;
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
