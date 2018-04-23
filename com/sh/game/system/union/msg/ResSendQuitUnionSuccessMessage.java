package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送退出帮会成功信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendQuitUnionSuccessMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendQuitUnionSuccessMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23015;
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
