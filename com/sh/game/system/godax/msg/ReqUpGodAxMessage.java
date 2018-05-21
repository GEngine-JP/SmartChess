package com.sh.game.system.godax.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求升级神斧</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUpGodAxMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUpGodAxMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 62001;
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
