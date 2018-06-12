package com.sh.game.system.shenzhu.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求龙神挑战领奖</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDragonChallengeRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDragonChallengeRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 47007;
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
