package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求英雄转生</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUpLevelHeroReinMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUpLevelHeroReinMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22011;
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
