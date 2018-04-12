package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送英雄转生信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendHeroReinInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendHeroReinInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22009;
	}
	
	/**
	 * 转生配置表id
	 */
	private int cfgId;

	/**
	 * 当前修为
	 */
	private int reinNum;

	/**
	 * 剩余兑换次数
	 */
	private int exchangeNum;

	/**
	 * 战斗力
	 */
	private int fightValue;


	public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

	
	public int getReinNum() {
		return reinNum;
	}

	public void setReinNum(int reinNum) {
		this.reinNum = reinNum;
	}

	
	public int getExchangeNum() {
		return exchangeNum;
	}

	public void setExchangeNum(int exchangeNum) {
		this.exchangeNum = exchangeNum;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.cfgId = readInt(buf, false);
		this.reinNum = readInt(buf, false);
		this.exchangeNum = readInt(buf, false);
		this.fightValue = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, cfgId, false);
		this.writeInt(buf, reinNum, false);
		this.writeInt(buf, exchangeNum, false);
		this.writeInt(buf, fightValue, false);

		return true;
	}
}

