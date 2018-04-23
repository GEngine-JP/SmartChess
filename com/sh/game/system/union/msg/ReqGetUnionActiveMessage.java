package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>获取帮会积分</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetUnionActiveMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetUnionActiveMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23020;
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
