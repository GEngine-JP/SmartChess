package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>发送帮会活跃信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendUnionActiveInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendUnionActiveInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23021;
	}
	
	/**
	 * 今日活跃点
	 */
	private int activePoint;

	/**
	 * 已领取的活跃奖励
	 */
	private List<Integer> activeId = new ArrayList<Integer>();


	public int getActivePoint() {
		return activePoint;
	}

	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}

	
	public List<Integer> getActiveId() {
		return activeId;
	}

	public void setActiveId(List<Integer> activeId) {
		this.activeId = activeId;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.activePoint = readInt(buf, false);
		int activeIdLength = readShort(buf);
		for (int activeIdI = 0; activeIdI < activeIdLength; activeIdI++) {
			this.activeId.add(this.readInt(buf, false));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activePoint, false);
		writeShort(buf, this.activeId.size());
		for (int activeIdI = 0; activeIdI < this.activeId.size(); activeIdI++) {
			this.writeInt(buf, this.activeId.get(activeIdI), false);
		}


		return true;
	}
}

