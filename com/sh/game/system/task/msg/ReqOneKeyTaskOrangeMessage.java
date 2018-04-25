package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求精英任务一键刷橙</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOneKeyTaskOrangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOneKeyTaskOrangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42007;
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
