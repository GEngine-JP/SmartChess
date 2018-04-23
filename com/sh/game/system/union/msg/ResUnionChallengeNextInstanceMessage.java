package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送行会挑战下一关卡信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResUnionChallengeNextInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUnionChallengeNextInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23031;
	}
	
	/**
	 * 下一关卡副本id
	 */
	private int nextInstanceId;

	public int getNextInstanceId() {
		return nextInstanceId;
	}

	public void setNextInstanceId(int nextInstanceId) {
		this.nextInstanceId = nextInstanceId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.nextInstanceId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, nextInstanceId, false);
		return true;
	}
}
