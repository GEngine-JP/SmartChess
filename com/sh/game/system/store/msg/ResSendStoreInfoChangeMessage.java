package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.store.msg.bean.StoreInfo;

/**
 * <p>发送商城单个物品变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendStoreInfoChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendStoreInfoChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16004;
	}
	
	/**
	 * 单个商品信息
	 */
	private StoreInfo storeInfo;

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			StoreInfo storeInfo = new StoreInfo();
			storeInfo.read(buf);
			this.storeInfo = storeInfo;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, storeInfo);
		return true;
	}
}
