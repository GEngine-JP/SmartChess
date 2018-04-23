package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求购买竞技场挑战次数</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqBuyArenaNumMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBuyArenaNumMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37007;
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
