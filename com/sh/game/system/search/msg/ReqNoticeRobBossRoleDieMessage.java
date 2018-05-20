package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通知探索抢BOSS事件假人死亡</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqNoticeRobBossRoleDieMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqNoticeRobBossRoleDieMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38012;
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
