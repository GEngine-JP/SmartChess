package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>充值成功的消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRechargeSuccessMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRechargeSuccessMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39007;
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
