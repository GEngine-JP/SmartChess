package com.sh.game.system.hero.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class HeroVeinBean extends KryoBean {

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

		this.newId = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, newId, false);
		this.writeInt(buf, fightValue, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
