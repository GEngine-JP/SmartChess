package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求开始探索</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqStartSearchMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqStartSearchMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38005;
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

