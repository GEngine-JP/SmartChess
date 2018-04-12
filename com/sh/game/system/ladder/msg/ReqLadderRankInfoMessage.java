package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求天梯排行榜</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLadderRankInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLadderRankInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5007;
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

