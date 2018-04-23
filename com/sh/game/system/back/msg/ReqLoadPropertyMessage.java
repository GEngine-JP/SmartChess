package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>刷property配置表</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLoadPropertyMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLoadPropertyMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43014;
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
