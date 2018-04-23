package com.sh.game.system.official.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求官职晋升</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOfficialUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOfficialUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 56002;
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
