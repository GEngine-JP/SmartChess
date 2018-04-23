package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>心跳返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeartMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeartMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1010;
	}
	
	/**
	 * 服务器时间 毫秒
	 */
	private long serverTime;

	public long getServerTime() {
		return serverTime;
	}

	public void setServerTime(long serverTime) {
		this.serverTime = serverTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.serverTime = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, serverTime);
		return true;
	}
}
