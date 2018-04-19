package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求精英任务扫荡</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqSweepEliteInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSweepEliteInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42006;
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

