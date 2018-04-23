package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.bag.msg.bean.BagItemBean;
import com.sh.game.system.bag.msg.bean.CoinBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>背包发生变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResBagChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBagChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10003;
	}
	
	/**
	 * 变化原因
	 */
	private int action;
	/**
	 * 道具列表
	 */
	private List<BagItemBean> itemList = new ArrayList<>();
	/**
	 * 货币列表
	 */
	private List<CoinBean> coinList = new ArrayList<>();
	/**
	 * 道具移除列表
	 */
	private List<Long> removedIdList = new ArrayList<>();

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
	public List<CoinBean> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinBean> coinList) {
		this.coinList = coinList;
	}
	public List<Long> getRemovedIdList() {
		return removedIdList;
	}

	public void setRemovedIdList(List<Long> removedIdList) {
		this.removedIdList = removedIdList;
	}

	@Override
	public boolean read(KryoInput buf) {

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
		}		int coinListLength = readShort(buf);
		for (int coinListI = 0; coinListI < coinListLength; coinListI++) {
			if (readByte(buf) == 0) { 
				this.coinList.add(null);
			} else {
				CoinBean coinBean = new CoinBean();
				coinBean.read(buf);
				this.coinList.add(coinBean);
			}
		}		int removedIdListLength = readShort(buf);
		for (int removedIdListI = 0; removedIdListI < removedIdListLength; removedIdListI++) {
			this.removedIdList.add(this.readLong(buf));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, action, false);
		writeShort(buf, this.itemList.size());
		for (int itemListI = 0; itemListI < this.itemList.size(); itemListI++) {
			this.writeBean(buf, this.itemList.get(itemListI));
		}		writeShort(buf, this.coinList.size());
		for (int coinListI = 0; coinListI < this.coinList.size(); coinListI++) {
			this.writeBean(buf, this.coinList.get(coinListI));
		}		writeShort(buf, this.removedIdList.size());
		for (int removedIdListI = 0; removedIdListI < this.removedIdList.size(); removedIdListI++) {
			this.writeLong(buf, this.removedIdList.get(removedIdListI));
		}
		return true;
	}
}
