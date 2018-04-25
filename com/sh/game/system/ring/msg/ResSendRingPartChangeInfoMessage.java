package com.sh.game.system.ring.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.ring.msg.bean.RingPartInfo;

/**
 * <p>发送特戒部位变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendRingPartChangeInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRingPartChangeInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 53004;
	}
	
	/**
	 * 改变的特戒部位
	 */
	private RingPartInfo changeInfo;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色0英雄1
	 */
	private int owner;
	/**
	 * 战斗力
	 */
	private int fightPower;
	/**
	 * 所属特戒的等级
	 */
	private int ringLevel;

	public RingPartInfo getChangeInfo() {
		return changeInfo;
	}

	public void setChangeInfo(RingPartInfo changeInfo) {
		this.changeInfo = changeInfo;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

		public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

		public int getRingLevel() {
		return ringLevel;
	}

	public void setRingLevel(int ringLevel) {
		this.ringLevel = ringLevel;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			RingPartInfo ringPartInfo = new RingPartInfo();
			ringPartInfo.read(buf);
			this.changeInfo = ringPartInfo;
		}
		this.heroId = readLong(buf);
		this.owner = readInt(buf, false);
		this.fightPower = readInt(buf, false);
		this.ringLevel = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, changeInfo);
		this.writeLong(buf, heroId);
		this.writeInt(buf, owner, false);
		this.writeInt(buf, fightPower, false);
		this.writeInt(buf, ringLevel, false);
		return true;
	}
}
