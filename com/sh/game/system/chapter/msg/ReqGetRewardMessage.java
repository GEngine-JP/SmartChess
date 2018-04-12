package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取每波的奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41003;
	}
	
	/**
	 * stageId
	 */
	private int stageId;


	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.stageId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, stageId, false);

		return true;
	}
}

