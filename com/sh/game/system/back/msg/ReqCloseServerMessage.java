package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求关服</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCloseServerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCloseServerMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43001;
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
