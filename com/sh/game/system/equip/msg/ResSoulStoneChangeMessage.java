package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.equip.msg.bean.SoulStoneBean;


/**
 * <p>返回魂石进阶信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSoulStoneChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSoulStoneChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13014;
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
	 * 结果 1成功 2失败
	 */
	private int result;

	/**
	 * 战斗力
	 */
	private int fightValue;

	/**
	 * 当前魂石信息
	 */
	private SoulStoneBean soulStoneBean;


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

	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	public SoulStoneBean getSoulStoneBean() {
		return soulStoneBean;
	}

	public void setSoulStoneBean(SoulStoneBean soulStoneBean) {
		this.soulStoneBean = soulStoneBean;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.result = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		if (readByte(buf) != 0) {
			SoulStoneBean soulStoneBean = new SoulStoneBean();
			soulStoneBean.read(buf);
			this.soulStoneBean = soulStoneBean;
		}

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, result, false);
		this.writeInt(buf, fightValue, false);
		this.writeBean(buf, soulStoneBean);

		return true;
	}
}

