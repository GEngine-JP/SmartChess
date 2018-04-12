package com.sh.game.system.fcm.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>防沉迷状态 1-5对应小时</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResFcmStateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResFcmStateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 34003;
	}
	
	/**
	 * 防沉迷状态
	 */
	private int fcmState;


	public int getFcmState() {
		return fcmState;
	}

	public void setFcmState(int fcmState) {
		this.fcmState = fcmState;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.fcmState = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, fcmState, false);

		return true;
	}
}

