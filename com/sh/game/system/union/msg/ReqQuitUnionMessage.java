package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求退出帮会信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqQuitUnionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqQuitUnionMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23014;
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

