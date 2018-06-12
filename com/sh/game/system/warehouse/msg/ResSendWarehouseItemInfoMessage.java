package com.sh.game.system.warehouse.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.warehouse.msg.bean.WarehouseItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送世界仓库库存信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendWarehouseItemInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendWarehouseItemInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 66002;
	}
	
	/**
	 * 库存列表
	 */
	private List<WarehouseItemBean> items = new ArrayList<>();
	/**
	 * 我的贡献
	 */
	private int contribution;

	public List<WarehouseItemBean> getItems() {
		return items;
	}

	public void setItems(List<WarehouseItemBean> items) {
		this.items = items;
	}
	public int getContribution() {
		return contribution;
	}

	public void setContribution(int contribution) {
		this.contribution = contribution;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int itemsLength = readShort(buf);
		for (int itemsI = 0; itemsI < itemsLength; itemsI++) {
			if (readByte(buf) == 0) { 
				this.items.add(null);
			} else {
				WarehouseItemBean warehouseItemBean = new WarehouseItemBean();
				warehouseItemBean.read(buf);
				this.items.add(warehouseItemBean);
			}
		}		this.contribution = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.items.size());
		for (int itemsI = 0; itemsI < this.items.size(); itemsI++) {
			this.writeBean(buf, this.items.get(itemsI));
		}		this.writeInt(buf, contribution, false);
		return true;
	}
}
