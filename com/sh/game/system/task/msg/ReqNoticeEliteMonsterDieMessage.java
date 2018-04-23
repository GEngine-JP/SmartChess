package com.sh.game.system.task.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通知精英任务怪物全死</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqNoticeEliteMonsterDieMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqNoticeEliteMonsterDieMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 42004;
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
