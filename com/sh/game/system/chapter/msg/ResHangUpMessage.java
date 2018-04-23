package com.sh.game.system.chapter.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回挂机奖励信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHangUpMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHangUpMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 41002;
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
