package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>角色请求兑换修为</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRoleExchangeReinMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRoleExchangeReinMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8008;
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
