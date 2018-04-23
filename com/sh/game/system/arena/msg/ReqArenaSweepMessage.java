package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>竞技场扫荡</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqArenaSweepMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqArenaSweepMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37011;
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
