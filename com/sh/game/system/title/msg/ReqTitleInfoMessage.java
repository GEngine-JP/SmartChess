package com.sh.game.system.title.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求威名信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqTitleInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqTitleInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 33002;
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

