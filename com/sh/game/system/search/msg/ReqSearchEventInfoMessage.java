package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求探索事件面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqSearchEventInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSearchEventInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38001;
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
