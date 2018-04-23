package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求开奖</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqOpenRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOpenRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54008;
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
