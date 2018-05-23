package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>护盾触发消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResDunTriggerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDunTriggerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20032;
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
