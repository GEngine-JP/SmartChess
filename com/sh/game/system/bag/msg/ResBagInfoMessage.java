package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.bag.msg.bean.BagItemBean;
import com.sh.game.system.bag.msg.bean.CoinBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>返回请求背包</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResBagInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBagInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10002;
	}
	
	/**
	 * 背包道具页签剩余空格的数量
	 */
	private int emptyItemGridCount;

	/**
	 * 背包装备页签剩余空格的数量
	 */
	private int emptyEquipGridCount;

	/**
	 * 背包装备页签总的格子的数量
	 */
	private int maxEquipGridCount;

	/**
	 * 符文剩余格子
	 */
	private int emptyRuneGridCount;

	/**
	 * 符文总格子
	 */
	private int maxRuneGridCount;

	/**
	 * 背包装备页签扩容的次数
	 */
	private int addGridCount;

	/**
	 * 道具列表
	 */
	private List<BagItemBean> itemList = new ArrayList<BagItemBean>();

	/**
	 * 货币列表
	 */
	private List<CoinBean> coinList = new ArrayList<CoinBean>();


	public int getEmptyItemGridCount() {
		return emptyItemGridCount;
	}

	public void setEmptyItemGridCount(int emptyItemGridCount) {
		this.emptyItemGridCount = emptyItemGridCount;
	}

	
	public int getEmptyEquipGridCount() {
		return emptyEquipGridCount;
	}

	public void setEmptyEquipGridCount(int emptyEquipGridCount) {
		this.emptyEquipGridCount = emptyEquipGridCount;
	}

	
	public int getMaxEquipGridCount() {
		return maxEquipGridCount;
	}

	public void setMaxEquipGridCount(int maxEquipGridCount) {
		this.maxEquipGridCount = maxEquipGridCount;
	}

	
	public int getEmptyRuneGridCount() {
		return emptyRuneGridCount;
	}

	public void setEmptyRuneGridCount(int emptyRuneGridCount) {
		this.emptyRuneGridCount = emptyRuneGridCount;
	}

	
	public int getMaxRuneGridCount() {
		return maxRuneGridCount;
	}

	public void setMaxRuneGridCount(int maxRuneGridCount) {
		this.maxRuneGridCount = maxRuneGridCount;
	}

	
	public int getAddGridCount() {
		return addGridCount;
	}

	public void setAddGridCount(int addGridCount) {
		this.addGridCount = addGridCount;
	}

	
	public List<BagItemBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<BagItemBean> itemList) {
		this.itemList = itemList;
	}

	public List<CoinBean> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinBean> coinList) {
		this.coinList = coinList;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.emptyItemGridCount = readInt(buf, false);
		this.emptyEquipGridCount = readInt(buf, false);
		this.maxEquipGridCount = readInt(buf, false);
		this.emptyRuneGridCount = readInt(buf, false);
		this.maxRuneGridCount = readInt(buf, false);
		this.addGridCount = readInt(buf, false);
		int itemListLength = readShort(buf);
		for (int itemListI = 0; itemListI < itemListLength; itemListI++) {
			if (readByte(buf) == 0) { 
				this.itemList.add(null);
			} else {
				BagItemBean bagItemBean = new BagItemBean();
				bagItemBean.read(buf);
				this.itemList.add(bagItemBean);
			}
		}

		int coinListLength = readShort(buf);
		for (int coinListI = 0; coinListI < coinListLength; coinListI++) {
			if (readByte(buf) == 0) { 
				this.coinList.add(null);
			} else {
				CoinBean coinBean = new CoinBean();
				coinBean.read(buf);
				this.coinList.add(coinBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, emptyItemGridCount, false);
		this.writeInt(buf, emptyEquipGridCount, false);
		this.writeInt(buf, maxEquipGridCount, false);
		this.writeInt(buf, emptyRuneGridCount, false);
		this.writeInt(buf, maxRuneGridCount, false);
		this.writeInt(buf, addGridCount, false);
		writeShort(buf, this.itemList.size());
		for (int itemListI = 0; itemListI < this.itemList.size(); itemListI++) {
			this.writeBean(buf, this.itemList.get(itemListI));
		}

		writeShort(buf, this.coinList.size());
		for (int coinListI = 0; coinListI < this.coinList.size(); coinListI++) {
			this.writeBean(buf, this.coinList.get(coinListI));
		}


		return true;
	}
}

