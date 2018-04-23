package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送可领取行会挑战通关奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCanGetCrossRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCanGetCrossRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23043;
	}
	
	/**
	 * 当前可领取的关卡
	 */
	private int floorId;
	/**
	 * 0不可领取 1可领取 2已领取
	 */
	private int state;

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.floorId = readInt(buf, false);
		this.state = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, floorId, false);
		this.writeInt(buf, state, false);
		return true;
	}
}
