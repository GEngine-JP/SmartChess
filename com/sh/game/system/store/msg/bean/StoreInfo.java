package com.sh.game.system.store.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class StoreInfo extends KryoBean {

	/**
	 * 商城id
	 */
	private int storeId;

	/**
	 * 单人每日限购已购数量
	 */
	private int dayBuyNum;

	/**
	 * 单人终身限购已购数量
	 */
	private int lifeBuyNum;

	/**
	 * 全服每日限购数量已购数量
	 */
	private int serverDayBuyNum;

	/**
	 * 全服终身限购数量已购数量
	 */
	private int serverLifeBuyNum;

	/**
	 * 购买和已售完状态 0可购买 1已售完
	 */
	private int buyState;

	/**
	 * 1 为打折
	 */
	private int isDiscount;


	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	
	public int getDayBuyNum() {
		return dayBuyNum;
	}

	public void setDayBuyNum(int dayBuyNum) {
		this.dayBuyNum = dayBuyNum;
	}

	
	public int getLifeBuyNum() {
		return lifeBuyNum;
	}

	public void setLifeBuyNum(int lifeBuyNum) {
		this.lifeBuyNum = lifeBuyNum;
	}

	
	public int getServerDayBuyNum() {
		return serverDayBuyNum;
	}

	public void setServerDayBuyNum(int serverDayBuyNum) {
		this.serverDayBuyNum = serverDayBuyNum;
	}

	
	public int getServerLifeBuyNum() {
		return serverLifeBuyNum;
	}

	public void setServerLifeBuyNum(int serverLifeBuyNum) {
		this.serverLifeBuyNum = serverLifeBuyNum;
	}

	
	public int getBuyState() {
		return buyState;
	}

	public void setBuyState(int buyState) {
		this.buyState = buyState;
	}

	
	public int getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.storeId = readInt(buf, false);
		this.dayBuyNum = readInt(buf, false);
		this.lifeBuyNum = readInt(buf, false);
		this.serverDayBuyNum = readInt(buf, false);
		this.serverLifeBuyNum = readInt(buf, false);
		this.buyState = readInt(buf, false);
		this.isDiscount = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, storeId, false);
		this.writeInt(buf, dayBuyNum, false);
		this.writeInt(buf, lifeBuyNum, false);
		this.writeInt(buf, serverDayBuyNum, false);
		this.writeInt(buf, serverLifeBuyNum, false);
		this.writeInt(buf, buyState, false);
		this.writeInt(buf, isDiscount, false);

		return true;
	}
}

