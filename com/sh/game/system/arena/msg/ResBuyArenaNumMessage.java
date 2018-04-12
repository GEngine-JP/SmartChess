package com.sh.game.system.arena.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回购买竞技场挑战次数</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResBuyArenaNumMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBuyArenaNumMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 37008;
	}
	
	/**
	 * 剩余挑战次数
	 */
	private int count;

	/**
	 * 当前第几次购买
	 */
	private int nowCount;

	/**
	 * 可购买次数上限
	 */
	private int limit;

	/**
	 * 下次增加次数的时间（秒数）
	 */
	private int needAddTime;


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public int getNowCount() {
		return nowCount;
	}

	public void setNowCount(int nowCount) {
		this.nowCount = nowCount;
	}

	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	
	public int getNeedAddTime() {
		return needAddTime;
	}

	public void setNeedAddTime(int needAddTime) {
		this.needAddTime = needAddTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.count = readInt(buf, false);
		this.nowCount = readInt(buf, false);
		this.limit = readInt(buf, false);
		this.needAddTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, count, false);
		this.writeInt(buf, nowCount, false);
		this.writeInt(buf, limit, false);
		this.writeInt(buf, needAddTime, false);

		return true;
	}
}

