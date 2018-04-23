package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回帮会BOSS副本归属信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResUnionInstanceOwnerMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResUnionInstanceOwnerMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23034;
	}
	
	/**
	 * 归属者id
	 */
	private long ownerId;

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.ownerId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, ownerId);
		return true;
	}
}
