package com.sh.game.system.redenvelop.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取红包</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDrawRedEnvelopMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDrawRedEnvelopMessage() {
		this.queueId = 0;
	}
	
	@Override
	public int getId() {
		return 63002;
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
