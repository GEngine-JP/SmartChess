package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>获取装备信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetItemInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetItemInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13016;
	}
	
	/**
	 * 唯一id
	 */
	private long armId;
	/**
	 * 道具id
	 */
	private int itemId;

	public long getArmId() {
		return armId;
	}

	public void setArmId(long armId) {
		this.armId = armId;
	}

		public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.armId = readLong(buf);
		this.itemId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, armId);
		this.writeInt(buf, itemId, false);
		return true;
	}
}
