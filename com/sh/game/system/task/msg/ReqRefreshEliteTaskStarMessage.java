package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求刷新精英任务星级</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRefreshEliteTaskStarMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRefreshEliteTaskStarMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42002;
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
