package com.sh.game.system.xiandan.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求仙丹信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqXianDanInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqXianDanInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 64004;
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
