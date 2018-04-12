package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求多人副本pk</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqFightToPlayerInInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqFightToPlayerInInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20021;
	}
	
	/**
	 * 目标id
	 */
	private long targetId;


	public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, targetId);

		return true;
	}
}

