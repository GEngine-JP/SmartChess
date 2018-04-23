package com.sh.game.system.runes.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求一键换装</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOneKeyPutOnRunesMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOneKeyPutOnRunesMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 24002;
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
