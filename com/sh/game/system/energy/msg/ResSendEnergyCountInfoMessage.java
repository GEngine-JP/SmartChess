package com.sh.game.system.energy.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回精力次数信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendEnergyCountInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEnergyCountInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 49001;
	}
	
	/**
	 * 剩余精力次数
	 */
	private int remainCount;

	/**
	 * 可购买次数
	 */
	private int canBuyNum;

	/**
	 * 已购买次数
	 */
	private int hasBuyNum;

	/**
	 * 下次点数回复时间
	 */
	private int addTime;


	public int getRemainCount() {
		return remainCount;
	}

	public void setRemainCount(int remainCount) {
		this.remainCount = remainCount;
	}

	
	public int getCanBuyNum() {
		return canBuyNum;
	}

	public void setCanBuyNum(int canBuyNum) {
		this.canBuyNum = canBuyNum;
	}

	
	public int getHasBuyNum() {
		return hasBuyNum;
	}

	public void setHasBuyNum(int hasBuyNum) {
		this.hasBuyNum = hasBuyNum;
	}

	
	public int getAddTime() {
		return addTime;
	}

	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.remainCount = readInt(buf, false);
		this.canBuyNum = readInt(buf, false);
		this.hasBuyNum = readInt(buf, false);
		this.addTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, remainCount, false);
		this.writeInt(buf, canBuyNum, false);
		this.writeInt(buf, hasBuyNum, false);
		this.writeInt(buf, addTime, false);

		return true;
	}
}

