package com.sh.game.system.warehouse.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class WarehouseItemBean extends KryoBean {

	/**
	 * 道具id
	 */
	private int itemId;
	/**
	 * 库存数量
	 */
	private int stockNum;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

		public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.itemId = readInt(buf, false);
		this.stockNum = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, itemId, false);
		this.writeInt(buf, stockNum, false);
		return true;
	}
}
