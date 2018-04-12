package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求指定商品能购买的最大数量</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqMaxBuyCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqMaxBuyCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16005;
	}
	
	/**
	 * store配置Id
	 */
	private int storeId;


	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.storeId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, storeId, false);

		return true;
	}
}

