package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通知登录成功</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResLoginMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLoginMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1007;
	}
	
	/**
	 * 玩家id
	 */
	private long uid;


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);

		return true;
	}
}

