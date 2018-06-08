package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.legacyEquip.msg.bean.ShenZhuangBean;

/**
 * <p>返回神装信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResShenZhuangInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResShenZhuangInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19009;
	}
	
	/**
	 * 神装
	 */
	private ShenZhuangBean shenZhuangBean;
	/**
	 * 战斗力
	 */
	private int fightValue;
	/**
	 * 类型 1 角色 2 英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;

	public ShenZhuangBean getShenZhuangBean() {
		return shenZhuangBean;
	}

	public void setShenZhuangBean(ShenZhuangBean shenZhuangBean) {
		this.shenZhuangBean = shenZhuangBean;
	}

		public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

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

	
	@Override
	public boolean read(KryoInput buf) {

		if (readByte(buf) != 0) {
			ShenZhuangBean shenZhuangBean = new ShenZhuangBean();
			shenZhuangBean.read(buf);
			this.shenZhuangBean = shenZhuangBean;
		}
		this.fightValue = readInt(buf, false);
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeBean(buf, shenZhuangBean);
		this.writeInt(buf, fightValue, false);
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
