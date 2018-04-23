package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>通过帮会id查询帮会</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqSendUnionInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqSendUnionInfoMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43034;
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
