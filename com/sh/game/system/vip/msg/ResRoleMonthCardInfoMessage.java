package com.sh.game.system.vip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回月卡信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRoleMonthCardInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRoleMonthCardInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 28001;
	}
	
	/**
	 * 是否有月卡生效 0否 1是
	 */
	private int isCard;

	/**
	 * 月卡剩余天数
	 */
	private int dayNum;

	/**
	 * 当天福利是否领取 0否 1是
	 */
	private int isGot;


	public int getIsCard() {
		return isCard;
	}

	public void setIsCard(int isCard) {
		this.isCard = isCard;
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
		this.isCard = readInt(buf, false);
		this.dayNum = readInt(buf, false);
		this.isGot = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, isCard, false);
		this.writeInt(buf, dayNum, false);
		this.writeInt(buf, isGot, false);

		return true;
	}
}

