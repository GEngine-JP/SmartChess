package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求自动禁言列表</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqAutoBanListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAutoBanListMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43027;
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

