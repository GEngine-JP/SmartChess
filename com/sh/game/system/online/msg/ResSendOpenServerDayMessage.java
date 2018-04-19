package com.sh.game.system.online.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送开服天数信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendOpenServerDayMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendOpenServerDayMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 32001;
	}
	
	/**
	 * 开服天数
	 */
	private int day;

	/**
	 * 开服时间戳
	 */
	private long time;

	/**
	 * 创角天数
	 */
	private int createDays;

	/**
	 * 合服次数
	 */
	private int mergeCount;


	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	
	public int getCreateDays() {
		return createDays;
	}

	public void setCreateDays(int createDays) {
		this.createDays = createDays;
	}

	
	public int getMergeCount() {
		return mergeCount;
	}

	public void setMergeCount(int mergeCount) {
		this.mergeCount = mergeCount;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.day = readInt(buf, false);
		this.time = readLong(buf);
		this.createDays = readInt(buf, false);
		this.mergeCount = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, day, false);
		this.writeLong(buf, time);
		this.writeInt(buf, createDays, false);
		this.writeInt(buf, mergeCount, false);

		return true;
	}
}

