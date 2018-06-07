package com.sh.game.system.shenzhu.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求龙珠挑战</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDragonChallengeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDragonChallengeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 47005;
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
