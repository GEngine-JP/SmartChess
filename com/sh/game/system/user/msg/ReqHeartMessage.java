package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>心跳请求</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqHeartMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqHeartMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1009;
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

