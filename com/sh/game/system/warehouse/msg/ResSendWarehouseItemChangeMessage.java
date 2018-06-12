package com.sh.game.system.warehouse.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.warehouse.msg.bean.WarehouseItemBean;

/**
 * <p>发送世界仓库库存变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendWarehouseItemChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendWarehouseItemChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 66005;
	}
	
	/**
	 * 变化库存信息
	 */
	private WarehouseItemBean changeItem;
	/**
	 * 我的贡献
	 */
	private int contribution;

	public WarehouseItemBean getChangeItem() {
		return changeItem;
	}

	public void setChangeItem(WarehouseItemBean changeItem) {
		this.changeItem = changeItem;
	}

		public int getContribution() {
		return contribution;
	}

	public void setContribution(int contribution) {
		this.contribution = contribution;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			WarehouseItemBean warehouseItemBean = new WarehouseItemBean();
			warehouseItemBean.read(buf);
			this.changeItem = warehouseItemBean;
		}
		this.contribution = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, changeItem);
		this.writeInt(buf, contribution, false);
		return true;
	}
}
