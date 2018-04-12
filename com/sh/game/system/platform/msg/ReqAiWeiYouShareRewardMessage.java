package com.sh.game.system.platform.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>分享奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqAiWeiYouShareRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAiWeiYouShareRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 44005;
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

