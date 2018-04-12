package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>英雄请求兑换修为</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqHeroExchangeReinMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqHeroExchangeReinMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22010;
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

