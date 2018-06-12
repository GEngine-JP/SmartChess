package com.sh.game.system.shenzhu.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求完成龙神挑战</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCompleteDragonChallengeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCompleteDragonChallengeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 47006;
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
