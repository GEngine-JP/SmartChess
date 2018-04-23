package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>请求vip回收装备</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqVipRecycleEquipmentMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqVipRecycleEquipmentMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10013;
	}
	
	/**
	 * 回收列表(唯一id)
	 */
	private List<Long> recycleList = new ArrayList<>();

	public List<Long> getRecycleList() {
		return recycleList;
	}

	public void setRecycleList(List<Long> recycleList) {
		this.recycleList = recycleList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int recycleListLength = readShort(buf);
		for (int recycleListI = 0; recycleListI < recycleListLength; recycleListI++) {
			this.recycleList.add(this.readLong(buf));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.recycleList.size());
		for (int recycleListI = 0; recycleListI < this.recycleList.size(); recycleListI++) {
			this.writeLong(buf, this.recycleList.get(recycleListI));
		}
		return true;
	}
}
