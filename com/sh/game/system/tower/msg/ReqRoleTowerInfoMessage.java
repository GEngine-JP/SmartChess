package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求通天塔面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRoleTowerInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRoleTowerInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54002;
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
