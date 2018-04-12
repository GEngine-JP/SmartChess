package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通知可以攻击雕像和守卫</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendCanAttackMonsterMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendCanAttackMonsterMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40016;
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

