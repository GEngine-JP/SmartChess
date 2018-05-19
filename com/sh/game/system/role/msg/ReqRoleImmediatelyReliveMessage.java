package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求立即复活</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRoleImmediatelyReliveMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRoleImmediatelyReliveMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8021;
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
