package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送英雄兑换修为结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResHeroExchangeReinResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeroExchangeReinResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22012;
	}
	
	/**
	 * 当前修为
	 */
	private int reinNum;

	/**
	 * 剩余兑换次数
	 */
	private int exchangeNum;

	/**
	 * 兑换后英雄等级
	 */
	private int heroLevel;


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

	
	public int getHeroLevel() {
		return heroLevel;
	}

	public void setHeroLevel(int heroLevel) {
		this.heroLevel = heroLevel;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.reinNum = readInt(buf, false);
		this.exchangeNum = readInt(buf, false);
		this.heroLevel = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, reinNum, false);
		this.writeInt(buf, exchangeNum, false);
		this.writeInt(buf, heroLevel, false);

		return true;
	}
}

