package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求和野外副本假人战斗</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqFightToFakeOutRobotMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFightToFakeOutRobotMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20025;
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
