package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求重置王者禁地层数</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqResetKingForbiddenFloorMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqResetKingForbiddenFloorMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45004;
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

