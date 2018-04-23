package com.sh.game.system.chat.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>查看他人信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLookOtherMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLookOtherMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 6006;
	}
	
	/**
	 * 查看的对象
	 */
	private long targetUid;

	public long getTargetUid() {
		return targetUid;
	}

	public void setTargetUid(long targetUid) {
		this.targetUid = targetUid;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.targetUid = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, targetUid);
		return true;
	}
}
