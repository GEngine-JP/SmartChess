package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求召唤行会boss（进入副本）</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqCallUnionBossMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCallUnionBossMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23044;
	}
	
	/**
	 * boss召唤令
	 */
	private int itemId;


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.itemId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, itemId, false);

		return true;
	}
}

