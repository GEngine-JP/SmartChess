package com.sh.game.system.refine.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.refine.msg.bean.RefineBean;

/**
 * <p>返回精炼结果</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResRefineResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRefineResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 55003;
	}
	
	/**
	 * 类型 1角色 2英雄
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
	 * 精炼结果
	 */
	private RefineBean refineInfo;

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

		public RefineBean getRefineInfo() {
		return refineInfo;
	}

	public void setRefineInfo(RefineBean refineInfo) {
		this.refineInfo = refineInfo;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.fightValue = readInt(buf, false);
		if (readByte(buf) != 0) {
			RefineBean refineBean = new RefineBean();
			refineBean.read(buf);
			this.refineInfo = refineBean;
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, fightValue, false);
		this.writeBean(buf, refineInfo);
		return true;
	}
}
