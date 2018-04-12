package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送选择的buff</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendGetBuffMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendGetBuffMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45010;
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

