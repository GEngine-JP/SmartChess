package com.sh.game.system.lingqi.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求灵器信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLingQiInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLingQiInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 61004;
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
