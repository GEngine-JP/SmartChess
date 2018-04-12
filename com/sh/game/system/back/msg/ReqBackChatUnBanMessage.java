package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>解除聊天禁言</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBackChatUnBanMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackChatUnBanMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43029;
	}
	
	/**
	 * uid
	 */
	private String uid;


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, uid);

		return true;
	}
}

