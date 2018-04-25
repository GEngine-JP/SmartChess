package com.sh.game.system.treasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回宝物信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeroTreasureInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroTreasureInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 14012;
	}
	
	/**
	 * 宝物id
	 */
	private int tid;
	/**
	 * 战斗力
	 */
	private int power;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

		public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.tid = readInt(buf, false);
		this.power = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, tid, false);
		this.writeInt(buf, power, false);
		return true;
	}
}
