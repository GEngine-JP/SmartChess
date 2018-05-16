package com.sh.game.system.mining.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.mining.msg.bean.WarehouseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送仓库信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResWarehouseMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResWarehouseMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 48003;
	}
	
	/**
	 * 仓库列表
	 */
	private List<WarehouseBean> warehouseList = new ArrayList<>();

	public List<WarehouseBean> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehouseBean> warehouseList) {
		this.warehouseList = warehouseList;
	}

	@Override
	public boolean read(KryoInput buf) {

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

		writeShort(buf, this.warehouseList.size());
		for (int warehouseListI = 0; warehouseListI < this.warehouseList.size(); warehouseListI++) {
			this.writeBean(buf, this.warehouseList.get(warehouseListI));
		}
		return true;
	}
}
