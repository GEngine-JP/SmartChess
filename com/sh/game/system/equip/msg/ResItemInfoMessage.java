package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回装备信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResItemInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResItemInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13015;
	}
	
	/**
	 * 唯一id
	 */
	private long armId;
	/**
	 * itemId
	 */
	private int itemId;
	/**
	 * 幸运
	 */
	private int luck;
	/**
	 * 剩余时间（秒）
	 */
	private int time;

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

		public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

		public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.armId = readLong(buf);
		this.itemId = readInt(buf, false);
		this.luck = readInt(buf, false);
		this.time = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, armId);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, luck, false);
		this.writeInt(buf, time, false);
		return true;
	}
}
