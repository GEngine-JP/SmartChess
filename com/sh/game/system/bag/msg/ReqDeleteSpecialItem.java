package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请删除特殊道具</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDeleteSpecialItem extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDeleteSpecialItem() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10014;
	}
	
	/**
	 * 道具唯一id
	 */
	private long uniqueId;

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uniqueId);
		return true;
	}
}
