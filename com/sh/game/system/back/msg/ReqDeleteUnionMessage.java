package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求解散帮会</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDeleteUnionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDeleteUnionMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43031;
	}
	
	/**
	 * 帮会id
	 */
	private long unionid;

	public long getUnionid() {
		return unionid;
	}

	public void setUnionid(long unionid) {
		this.unionid = unionid;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.unionid = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, unionid);
		return true;
	}
}
