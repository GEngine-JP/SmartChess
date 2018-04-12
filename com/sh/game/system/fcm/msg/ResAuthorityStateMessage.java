package com.sh.game.system.fcm.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>认证状态</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResAuthorityStateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResAuthorityStateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 34001;
	}
	
	/**
	 * 是否已认证
	 */
	private boolean state;


	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.state = readBoolean(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeBoolean(buf, state);

		return true;
	}
}

