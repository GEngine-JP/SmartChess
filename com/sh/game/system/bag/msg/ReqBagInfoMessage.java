package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求背包信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBagInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBagInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10001;
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

