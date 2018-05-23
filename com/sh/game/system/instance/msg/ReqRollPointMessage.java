package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求roll点</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRollPointMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRollPointMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20034;
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
