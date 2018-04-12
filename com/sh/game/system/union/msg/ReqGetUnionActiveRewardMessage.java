package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>获取帮会活跃奖励信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetUnionActiveRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetUnionActiveRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23022;
	}
	
	/**
	 * 要领取的活跃id
	 */
	private int activeId;


	public int getActiveId() {
		return activeId;
	}

	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.activeId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, activeId, false);

		return true;
	}
}

