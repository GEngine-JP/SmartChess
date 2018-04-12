package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求烧猪副本结束</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqFirePigInsEndMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFirePigInsEndMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20022;
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

