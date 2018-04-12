package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求重置行會挑戰</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqResetUnionChallengeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqResetUnionChallengeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23046;
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

