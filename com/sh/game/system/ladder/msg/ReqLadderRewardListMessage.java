package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取天梯排行榜奖励的列表数据</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLadderRewardListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLadderRewardListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5012;
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

