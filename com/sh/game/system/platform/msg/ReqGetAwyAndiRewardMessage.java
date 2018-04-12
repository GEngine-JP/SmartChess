package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>获取爱微游实名认证奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetAwyAndiRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetAwyAndiRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44012;
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

