package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.bag.msg.bean.BagItemBean;
import com.sh.game.system.bag.msg.bean.BagEquipBean;
import com.sh.game.system.bag.msg.bean.CoinBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>背包发生变化</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResBagChangeMessage2 extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBagChangeMessage2() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10012;
	}
	
	/**
	 * 背包道具页签空格的数量
	 */
	private int emptyItemGridCount;

	/**
	 * 背包装备页签空格的数量
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
	 * 变化原因
	 */
	private int action;

	/**
	 * 道具列表，变化这个消息如果itemId=null的话，那么这个索引的位置就被移除了，其他的则为变化
	 */
	private List<BagItemBean> itemList = new ArrayList<BagItemBean>();

	/**
	 * 装备列表
	 */
	private List<BagEquipBean> equipList = new ArrayList<BagEquipBean>();

	/**
	 * 符文列表
	 */
	private List<BagEquipBean> runeList = new ArrayList<BagEquipBean>();

	/**
	 * 货币列表
	 */
	private List<CoinBean> coinList = new ArrayList<CoinBean>();

	/**
	 * 道具出现空格时发
	 */
	private List<Long> uniqueItemId = new ArrayList<Long>();

	/**
	 * 移除装备时发
	 */
	private List<Long> uniqueEquipId = new ArrayList<Long>();

	/**
	 * 移除符文时发
	 */
	private List<Long> uniqueRuneId = new ArrayList<Long>();


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

	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	
	public List<BagItemBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<BagItemBean> itemList) {
		this.itemList = itemList;
	}

	public List<BagEquipBean> getEquipList() {
		return equipList;
	}

	public void setEquipList(List<BagEquipBean> equipList) {
		this.equipList = equipList;
	}

	public List<BagEquipBean> getRuneList() {
		return runeList;
	}

	public void setRuneList(List<BagEquipBean> runeList) {
		this.runeList = runeList;
	}

	public List<CoinBean> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinBean> coinList) {
		this.coinList = coinList;
	}

	public List<Long> getUniqueItemId() {
		return uniqueItemId;
	}

	public void setUniqueItemId(List<Long> uniqueItemId) {
		this.uniqueItemId = uniqueItemId;
	}

	public List<Long> getUniqueEquipId() {
		return uniqueEquipId;
	}

	public void setUniqueEquipId(List<Long> uniqueEquipId) {
		this.uniqueEquipId = uniqueEquipId;
	}

	public List<Long> getUniqueRuneId() {
		return uniqueRuneId;
	}

	public void setUniqueRuneId(List<Long> uniqueRuneId) {
		this.uniqueRuneId = uniqueRuneId;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.emptyItemGridCount = readInt(buf, false);
		this.emptyEquipGridCount = readInt(buf, false);
		this.maxEquipGridCount = readInt(buf, false);
		this.emptyRuneGridCount = readInt(buf, false);
		this.maxRuneGridCount = readInt(buf, false);
		this.action = readInt(buf, false);
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

		int equipListLength = readShort(buf);
		for (int equipListI = 0; equipListI < equipListLength; equipListI++) {
			if (readByte(buf) == 0) { 
				this.equipList.add(null);
			} else {
				BagEquipBean bagEquipBean = new BagEquipBean();
				bagEquipBean.read(buf);
				this.equipList.add(bagEquipBean);
			}
		}

		int runeListLength = readShort(buf);
		for (int runeListI = 0; runeListI < runeListLength; runeListI++) {
			if (readByte(buf) == 0) { 
				this.runeList.add(null);
			} else {
				BagEquipBean bagEquipBean = new BagEquipBean();
				bagEquipBean.read(buf);
				this.runeList.add(bagEquipBean);
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

		int uniqueItemIdLength = readShort(buf);
		for (int uniqueItemIdI = 0; uniqueItemIdI < uniqueItemIdLength; uniqueItemIdI++) {
			this.uniqueItemId.add(this.readLong(buf));
		}

		int uniqueEquipIdLength = readShort(buf);
		for (int uniqueEquipIdI = 0; uniqueEquipIdI < uniqueEquipIdLength; uniqueEquipIdI++) {
			this.uniqueEquipId.add(this.readLong(buf));
		}

		int uniqueRuneIdLength = readShort(buf);
		for (int uniqueRuneIdI = 0; uniqueRuneIdI < uniqueRuneIdLength; uniqueRuneIdI++) {
			this.uniqueRuneId.add(this.readLong(buf));
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
		this.writeInt(buf, action, false);
		writeShort(buf, this.itemList.size());
		for (int itemListI = 0; itemListI < this.itemList.size(); itemListI++) {
			this.writeBean(buf, this.itemList.get(itemListI));
		}

		writeShort(buf, this.equipList.size());
		for (int equipListI = 0; equipListI < this.equipList.size(); equipListI++) {
			this.writeBean(buf, this.equipList.get(equipListI));
		}

		writeShort(buf, this.runeList.size());
		for (int runeListI = 0; runeListI < this.runeList.size(); runeListI++) {
			this.writeBean(buf, this.runeList.get(runeListI));
		}

		writeShort(buf, this.coinList.size());
		for (int coinListI = 0; coinListI < this.coinList.size(); coinListI++) {
			this.writeBean(buf, this.coinList.get(coinListI));
		}

		writeShort(buf, this.uniqueItemId.size());
		for (int uniqueItemIdI = 0; uniqueItemIdI < this.uniqueItemId.size(); uniqueItemIdI++) {
			this.writeLong(buf, this.uniqueItemId.get(uniqueItemIdI));
		}

		writeShort(buf, this.uniqueEquipId.size());
		for (int uniqueEquipIdI = 0; uniqueEquipIdI < this.uniqueEquipId.size(); uniqueEquipIdI++) {
			this.writeLong(buf, this.uniqueEquipId.get(uniqueEquipIdI));
		}

		writeShort(buf, this.uniqueRuneId.size());
		for (int uniqueRuneIdI = 0; uniqueRuneIdI < this.uniqueRuneId.size(); uniqueRuneIdI++) {
			this.writeLong(buf, this.uniqueRuneId.get(uniqueRuneIdI));
		}


		return true;
	}
}

