package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取月卡每日福利</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetCardDayRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetCardDayRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28002;
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

