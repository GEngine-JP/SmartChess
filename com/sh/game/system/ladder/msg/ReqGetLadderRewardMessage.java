package com.sh.game.system.ladder.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取段位奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetLadderRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetLadderRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 5010;
	}
	
	/**
	 * 段位id
	 */
	private int ladderId;


	public int getLadderId() {
		return ladderId;
	}

	public void setLadderId(int ladderId) {
		this.ladderId = ladderId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.ladderId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, ladderId, false);

		return true;
	}
}

