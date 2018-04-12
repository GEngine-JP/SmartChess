package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回指定商品能购买的最大数量</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResMaxBuyCountMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMaxBuyCountMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16006;
	}
	
	/**
	 * storeId
	 */
	private int storeId;

	/**
	 * 最大购买数量
	 */
	private int maxCount;

	/**
	 * 当前购买次数
	 */
	private int dayCount;


	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	
	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	
	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.storeId = readInt(buf, false);
		this.maxCount = readInt(buf, false);
		this.dayCount = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, storeId, false);
		this.writeInt(buf, maxCount, false);
		this.writeInt(buf, dayCount, false);

		return true;
	}
}

