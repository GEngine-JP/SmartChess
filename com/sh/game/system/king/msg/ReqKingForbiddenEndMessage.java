package com.sh.game.system.king.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通知王者禁地结束</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqKingForbiddenEndMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqKingForbiddenEndMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 45008;
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
