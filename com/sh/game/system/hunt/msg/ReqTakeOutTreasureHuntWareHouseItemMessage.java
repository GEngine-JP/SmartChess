package com.sh.game.system.hunt.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求取出寻宝仓库道具</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqTakeOutTreasureHuntWareHouseItemMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqTakeOutTreasureHuntWareHouseItemMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 11006;
	}
	
	/**
	 * 道具唯一Id
	 */
	private long uniqueId;
	/**
	 * 道具Id
	 */
	private int itemId;
	/**
	 * 道具数量
	 */
	private int num;
	/**
	 * 是否全部取出 0不是 1是
	 */
	private int isAllTake;

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

		public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

		public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

		public int getIsAllTake() {
		return isAllTake;
	}

	public void setIsAllTake(int isAllTake) {
		this.isAllTake = isAllTake;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uniqueId = readLong(buf);
		this.itemId = readInt(buf, false);
		this.num = readInt(buf, false);
		this.isAllTake = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uniqueId);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, num, false);
		this.writeInt(buf, isAllTake, false);
		return true;
	}
}
