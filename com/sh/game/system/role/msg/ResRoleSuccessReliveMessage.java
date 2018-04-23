package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送立即复活成功消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRoleSuccessReliveMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleSuccessReliveMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8022;
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
