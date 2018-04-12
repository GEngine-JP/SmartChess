package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回退出副本（通用）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResExitInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResExitInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20012;
	}
	
	/**
	 * 关卡id
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

