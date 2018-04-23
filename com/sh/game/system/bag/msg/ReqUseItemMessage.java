package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求使用道具</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUseItemMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseItemMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10004;
	}
	
	/**
	 * 道具数量
	 */
	private int count;
	/**
	 * 道具id
	 */
	private int itemId;
	/**
	 * 使用参数
	 */
	private int clientParam;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

		public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

		public int getClientParam() {
		return clientParam;
	}

	public void setClientParam(int clientParam) {
		this.clientParam = clientParam;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.count = readInt(buf, false);
		this.itemId = readInt(buf, false);
		this.clientParam = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, count, false);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, clientParam, false);
		return true;
	}
}
