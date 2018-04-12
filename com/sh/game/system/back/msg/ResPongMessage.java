package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>pong消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResPongMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResPongMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43007;
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

