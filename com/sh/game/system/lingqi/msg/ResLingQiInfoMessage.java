package com.sh.game.system.lingqi.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>灵器领取信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLingQiInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLingQiInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 61003;
	}
	
	/**
	 * 已领取id列表
	 */
	private List<Integer> lingQiIdList = new ArrayList<>();

	public List<Integer> getLingQiIdList() {
		return lingQiIdList;
	}

	public void setLingQiIdList(List<Integer> lingQiIdList) {
		this.lingQiIdList = lingQiIdList;
	}

	@Override
	public boolean read(KryoInput buf) {

		int lingQiIdListLength = readShort(buf);
		for (int lingQiIdListI = 0; lingQiIdListI < lingQiIdListLength; lingQiIdListI++) {
			this.lingQiIdList.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.lingQiIdList.size());
		for (int lingQiIdListI = 0; lingQiIdListI < this.lingQiIdList.size(); lingQiIdListI++) {
			this.writeInt(buf, this.lingQiIdList.get(lingQiIdListI), false);
		}
		return true;
	}
}
