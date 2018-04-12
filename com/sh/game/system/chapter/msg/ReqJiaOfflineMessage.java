package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>最小化奖励的消息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqJiaOfflineMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqJiaOfflineMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41008;
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

