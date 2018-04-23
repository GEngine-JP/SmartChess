package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求拾取主线boss奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPickUpMainTaskBossMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPickUpMainTaskBossMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30009;
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
