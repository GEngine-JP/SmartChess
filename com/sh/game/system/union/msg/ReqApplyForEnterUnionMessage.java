package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>申请加入帮会</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqApplyForEnterUnionMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqApplyForEnterUnionMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23001;
	}
	
	/**
	 * 申请的帮会id
	 */
	private long unionId;


	public long getUnionId() {
		return unionId;
	}

	public void setUnionId(long unionId) {
		this.unionId = unionId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.unionId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, unionId);

		return true;
	}
}

