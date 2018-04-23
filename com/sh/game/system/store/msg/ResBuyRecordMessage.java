package com.sh.game.system.store.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送购买记录</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResBuyRecordMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBuyRecordMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 16008;
	}
	
	/**
	 * storeIdList
	 */
	private List<Integer> storeIdList = new ArrayList<>();

	public List<Integer> getStoreIdList() {
		return storeIdList;
	}

	public void setStoreIdList(List<Integer> storeIdList) {
		this.storeIdList = storeIdList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int storeIdListLength = readShort(buf);
		for (int storeIdListI = 0; storeIdListI < storeIdListLength; storeIdListI++) {
			this.storeIdList.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.storeIdList.size());
		for (int storeIdListI = 0; storeIdListI < this.storeIdList.size(); storeIdListI++) {
			this.writeInt(buf, this.storeIdList.get(storeIdListI), false);
		}
		return true;
	}
}
