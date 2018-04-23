package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求发送召唤公告</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqSendUnionAnnounceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSendUnionAnnounceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23035;
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
