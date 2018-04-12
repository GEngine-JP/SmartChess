package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回解散帮会信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResDeleteUnionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResDeleteUnionMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43032;
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

