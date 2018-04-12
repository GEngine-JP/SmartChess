package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>请求处理申请列表信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqCheckApplyListMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCheckApplyListMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23018;
	}
	
	/**
	 * 选择处理的申请玩家列表
	 */
	private List<Long> list = new ArrayList<Long>();

	/**
	 * 处理方式 1拒绝2同意
	 */
	private int checkState;


	public List<Long> getList() {
		return list;
	}

	public void setList(List<Long> list) {
		this.list = list;
	}

	public int getCheckState() {
		return checkState;
	}

	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		int listLength = readShort(buf);
		for (int listI = 0; listI < listLength; listI++) {
			this.list.add(this.readLong(buf));
		}

		this.checkState = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		writeShort(buf, this.list.size());
		for (int listI = 0; listI < this.list.size(); listI++) {
			this.writeLong(buf, this.list.get(listI));
		}

		this.writeInt(buf, checkState, false);

		return true;
	}
}

