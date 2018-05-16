package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送经脉变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendVeinChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendVeinChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22014;
	}
	
	/**
	 * 类型 1 角色 2 英雄
	 */
	private int type;
	/**
	 * 现在的配置表id
	 */
	private int newId;
	/**
	 * 战斗力
	 */
	private int fightValue;
	/**
	 * 英雄Id
	 */
	private long heroId;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.newId = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, newId, false);
		this.writeInt(buf, fightValue, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
