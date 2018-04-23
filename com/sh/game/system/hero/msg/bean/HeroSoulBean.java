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

public class HeroSoulBean extends KryoBean {

	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 灵魂刻印等级对应配置id
	 */
	private int soulId;
	/**
	 * 战斗力
	 */
	private int fightPower;

	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getSoulId() {
		return soulId;
	}

	public void setSoulId(int soulId) {
		this.soulId = soulId;
	}

		public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.heroId = readLong(buf);
		this.soulId = readInt(buf, false);
		this.fightPower = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, heroId);
		this.writeInt(buf, soulId, false);
		this.writeInt(buf, fightPower, false);
		return true;
	}
}
