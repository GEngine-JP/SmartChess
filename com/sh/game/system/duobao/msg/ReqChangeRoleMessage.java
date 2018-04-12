package com.sh.game.system.duobao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求换一批玩家</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqChangeRoleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqChangeRoleMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48005;
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

