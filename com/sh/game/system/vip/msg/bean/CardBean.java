package com.sh.game.system.vip.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class CardBean extends KryoBean {

	/**
	 * 月卡id
	 */
	private int cardId;
	/**
	 * 月卡剩余天数
	 */
	private int dayNum;
	/**
	 * 当天福利是否领取 0否 1是
	 */
	private int isGot;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

		public int getDayNum() {
		return dayNum;
	}

	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

		public int getIsGot() {
		return isGot;
	}

	public void setIsGot(int isGot) {
		this.isGot = isGot;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cardId = readInt(buf, false);
		this.dayNum = readInt(buf, false);
		this.isGot = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cardId, false);
		this.writeInt(buf, dayNum, false);
		this.writeInt(buf, isGot, false);
		return true;
	}
}
