package com.sh.game.system.search.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回探索事件其他信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendSearchOtherInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendSearchOtherInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 38003;
	}
	
	/**
	 * pk值
	 */
	private int pkCount;
	/**
	 * pk排名
	 */
	private int pkRank;
	/**
	 * 疲劳值
	 */
	private int tiredNum;
	/**
	 * 可探索时间戳
	 */
	private int canSearchTime;
	/**
	 * 已购买次数
	 */
	private int hasBuyNum;
	/**
	 * 最大购买次数
	 */
	private int maxBuyNum;
	/**
	 * 时间间隔事件下次刷新时间（秒）
	 */
	private int nextTime;

	public int getPkCount() {
		return pkCount;
	}

	public void setPkCount(int pkCount) {
		this.pkCount = pkCount;
	}

		public int getPkRank() {
		return pkRank;
	}

	public void setPkRank(int pkRank) {
		this.pkRank = pkRank;
	}

		public int getTiredNum() {
		return tiredNum;
	}

	public void setTiredNum(int tiredNum) {
		this.tiredNum = tiredNum;
	}

		public int getCanSearchTime() {
		return canSearchTime;
	}

	public void setCanSearchTime(int canSearchTime) {
		this.canSearchTime = canSearchTime;
	}

		public int getHasBuyNum() {
		return hasBuyNum;
	}

	public void setHasBuyNum(int hasBuyNum) {
		this.hasBuyNum = hasBuyNum;
	}

		public int getMaxBuyNum() {
		return maxBuyNum;
	}

	public void setMaxBuyNum(int maxBuyNum) {
		this.maxBuyNum = maxBuyNum;
	}

		public int getNextTime() {
		return nextTime;
	}

	public void setNextTime(int nextTime) {
		this.nextTime = nextTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.pkCount = readInt(buf, false);
		this.pkRank = readInt(buf, false);
		this.tiredNum = readInt(buf, false);
		this.canSearchTime = readInt(buf, false);
		this.hasBuyNum = readInt(buf, false);
		this.maxBuyNum = readInt(buf, false);
		this.nextTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, pkCount, false);
		this.writeInt(buf, pkRank, false);
		this.writeInt(buf, tiredNum, false);
		this.writeInt(buf, canSearchTime, false);
		this.writeInt(buf, hasBuyNum, false);
		this.writeInt(buf, maxBuyNum, false);
		this.writeInt(buf, nextTime, false);
		return true;
	}
}
