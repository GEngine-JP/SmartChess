package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通知烧猪副本boss死亡</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqNoticeFirePigInstanceBossDieMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqNoticeFirePigInstanceBossDieMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20017;
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
