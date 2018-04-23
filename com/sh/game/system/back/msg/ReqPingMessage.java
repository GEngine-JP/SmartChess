package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>ping消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPingMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPingMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43006;
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
