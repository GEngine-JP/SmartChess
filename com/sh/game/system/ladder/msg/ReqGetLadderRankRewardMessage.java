package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>领取天梯排行榜奖励请求</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetLadderRankRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetLadderRankRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5009;
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
