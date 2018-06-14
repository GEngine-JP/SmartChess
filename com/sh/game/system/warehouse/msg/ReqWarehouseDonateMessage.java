package com.sh.game.system.warehouse.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求世界仓库捐献</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqWarehouseDonateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqWarehouseDonateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 66003;
	}
	
	/**
	 * 要捐献的道具
	 */
	private int itemId;
	/**
	 * 要捐献的数量
	 */
	private int count;

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

		this.itemId = readInt(buf, false);
		this.count = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, itemId, false);
		this.writeInt(buf, count, false);
		return true;
	}
}