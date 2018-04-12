package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>烧猪副本结算结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendFirePigRewardResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendFirePigRewardResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20030;
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

