package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求竞技场信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqArenaInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqArenaInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37001;
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
