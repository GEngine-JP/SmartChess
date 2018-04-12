package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求玩家挖矿信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRoleMiningInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRoleMiningInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48001;
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

