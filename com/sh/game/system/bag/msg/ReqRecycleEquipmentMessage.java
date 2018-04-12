package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>请求回收装备</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqRecycleEquipmentMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRecycleEquipmentMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10007;
	}
	
	/**
	 * 回收列表(唯一id)
	 */
	private List<Long> recycleList = new ArrayList<Long>();


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

