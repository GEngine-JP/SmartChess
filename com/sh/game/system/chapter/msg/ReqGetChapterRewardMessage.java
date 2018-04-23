package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取关卡奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetChapterRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetChapterRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41013;
	}
	
	/**
	 * 要领取的关卡id
	 */
	private int advanceId;

	public int getAdvanceId() {
		return advanceId;
	}

	public void setAdvanceId(int advanceId) {
		this.advanceId = advanceId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.advanceId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, advanceId, false);
		return true;
	}
}
