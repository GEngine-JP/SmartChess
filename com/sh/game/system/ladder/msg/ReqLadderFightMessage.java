package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求匹配</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLadderFightMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLadderFightMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5001;
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
