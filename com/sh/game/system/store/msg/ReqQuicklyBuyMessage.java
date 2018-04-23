package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求购买</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqQuicklyBuyMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqQuicklyBuyMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16001;
	}
	
	/**
	 * 快捷购买配置id
	 */
	private int storeId;
	/**
	 * 购买数量
	 */
	private int count;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.storeId = readInt(buf, false);
		this.count = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, storeId, false);
		this.writeInt(buf, count, false);
		return true;
	}
}
