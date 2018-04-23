package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.wing.msg.bean.WingBean;

/**
 * <p>返回升级光翼</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLevelUpWingMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLevelUpWingMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18005;
	}
	
	/**
	 * 1角色光翼 2英雄光翼
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 战斗力
	 */
	private int fightValue;
	/**
	 * 光翼
	 */
	private WingBean wingBean;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

		public WingBean getWingBean() {
		return wingBean;
	}

	public void setWingBean(WingBean wingBean) {
		this.wingBean = wingBean;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.fightValue = readInt(buf, false);
		if (readByte(buf) != 0) {
			WingBean wingBean = new WingBean();
			wingBean.read(buf);
			this.wingBean = wingBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, fightValue, false);
		this.writeBean(buf, wingBean);
		return true;
	}
}
