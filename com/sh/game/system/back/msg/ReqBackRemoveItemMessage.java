package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>通过后台发道具</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBackRemoveItemMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackRemoveItemMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43018;
	}
	
	/**
	 * 玩家唯一id
	 */
	private long uid;

	/**
	 * 道具Id
	 */
	private int itemId;

	/**
	 * 数量
	 */
	private int count;


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readLong(buf);
		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);

		return true;
	}
}

