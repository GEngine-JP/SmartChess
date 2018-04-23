package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>查找角色</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetRoleMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetRoleMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43042;
	}
	
	/**
	 * uid
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
