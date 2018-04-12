package com.sh.game.system.energy.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求购买精力次数</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBuEnergyCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBuEnergyCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 49002;
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

