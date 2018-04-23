package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求获取抢夺日志</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRobLogMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRobLogMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48010;
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
