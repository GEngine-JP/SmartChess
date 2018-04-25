package com.sh.game.system.tower.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.tower.msg.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送通天塔副本掉落</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResTowerBossDropMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResTowerBossDropMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 54011;
	}
	
	/**
	 * 掉落
	 */
	private List<ItemBean> itemBeanList = new ArrayList<>();
	/**
	 * 抽奖次数
	 */
	private int times;

	public List<ItemBean> getItemBeanList() {
		return itemBeanList;
	}

	public void setItemBeanList(List<ItemBean> itemBeanList) {
		this.itemBeanList = itemBeanList;
	}
	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int itemBeanListLength = readShort(buf);
		for (int itemBeanListI = 0; itemBeanListI < itemBeanListLength; itemBeanListI++) {
			if (readByte(buf) == 0) { 
				this.itemBeanList.add(null);
			} else {
				ItemBean itemBean = new ItemBean();
				itemBean.read(buf);
				this.itemBeanList.add(itemBean);
			}
		}		this.times = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.itemBeanList.size());
		for (int itemBeanListI = 0; itemBeanListI < this.itemBeanList.size(); itemBeanListI++) {
			this.writeBean(buf, this.itemBeanList.get(itemBeanListI));
		}		this.writeInt(buf, times, false);
		return true;
	}
}
