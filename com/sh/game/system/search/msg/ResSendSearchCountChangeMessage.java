package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回探索事件次数变化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendSearchCountChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSearchCountChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38003;
	}
	
	/**
	 * 剩余探索次数
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
	/**
	 * 时间间隔事件剩余可完成次数
	 */
	private int canComplete;
	/**
	 * 时间间隔事件下次刷新时间（秒）
	 */
	private int nextTime;

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

		public int getCanComplete() {
		return canComplete;
	}

	public void setCanComplete(int canComplete) {
		this.canComplete = canComplete;
	}

		public int getNextTime() {
		return nextTime;
	}

	public void setNextTime(int nextTime) {
		this.nextTime = nextTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.remainCount = readInt(buf, false);
		this.canBuyNum = readInt(buf, false);
		this.hasBuyNum = readInt(buf, false);
		this.addTime = readInt(buf, false);
		this.canComplete = readInt(buf, false);
		this.nextTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, remainCount, false);
		this.writeInt(buf, canBuyNum, false);
		this.writeInt(buf, hasBuyNum, false);
		this.writeInt(buf, addTime, false);
		this.writeInt(buf, canComplete, false);
		this.writeInt(buf, nextTime, false);
		return true;
	}
}
