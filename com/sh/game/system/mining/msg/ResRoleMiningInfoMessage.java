package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.mining.msg.bean.MinerBean;
import com.sh.game.system.mining.msg.bean.WarehouseBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送玩家挖矿信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRoleMiningInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleMiningInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48002;
	}
	
	/**
	 * 矿工列表
	 */
	private List<MinerBean> minerList = new ArrayList<MinerBean>();

	/**
	 * 仓库列表
	 */
	private List<WarehouseBean> warehouseList = new ArrayList<WarehouseBean>();


	public List<MinerBean> getMinerList() {
		return minerList;
	}

	public void setMinerList(List<MinerBean> minerList) {
		this.minerList = minerList;
	}

	public List<WarehouseBean> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehouseBean> warehouseList) {
		this.warehouseList = warehouseList;
	}


	@Override
	public boolean read(KryoInput buf) {
		int minerListLength = readShort(buf);
		for (int minerListI = 0; minerListI < minerListLength; minerListI++) {
			if (readByte(buf) == 0) { 
				this.minerList.add(null);
			} else {
				MinerBean minerBean = new MinerBean();
				minerBean.read(buf);
				this.minerList.add(minerBean);
			}
		}

		int warehouseListLength = readShort(buf);
		for (int warehouseListI = 0; warehouseListI < warehouseListLength; warehouseListI++) {
			if (readByte(buf) == 0) { 
				this.warehouseList.add(null);
			} else {
				WarehouseBean warehouseBean = new WarehouseBean();
				warehouseBean.read(buf);
				this.warehouseList.add(warehouseBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.minerList.size());
		for (int minerListI = 0; minerListI < this.minerList.size(); minerListI++) {
			this.writeBean(buf, this.minerList.get(minerListI));
		}

		writeShort(buf, this.warehouseList.size());
		for (int warehouseListI = 0; warehouseListI < this.warehouseList.size(); warehouseListI++) {
			this.writeBean(buf, this.warehouseList.get(warehouseListI));
		}


		return true;
	}
}

