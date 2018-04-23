package com.sh.game.system.boss.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class BossInfo extends KryoBean {

	/**
	 * 副本id
	 */
	private int instanceId;
	/**
	 * 类型
	 */
	private int type;
	/**
	 * 剩余次数
	 */
	private int surplusNum;
	/**
	 * 下次刷新时间
	 */
	private int freshTime;
	/**
	 * 当前血量
	 */
	private long hp;
	/**
	 * 人数
	 */
	private int num;
	/**
	 * 归属人
	 */
	private String ownerName;
	/**
	 * 状态 0未勾选 1勾选 
	 */
	private int state;
	/**
	 * 扫荡次数
	 */
	private int sweepCount;
	/**
	 * 是否通关过这个副本
	 */
	private int isSucceed;

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getSurplusNum() {
		return surplusNum;
	}

	public void setSurplusNum(int surplusNum) {
		this.surplusNum = surplusNum;
	}

		public int getFreshTime() {
		return freshTime;
	}

	public void setFreshTime(int freshTime) {
		this.freshTime = freshTime;
	}

		public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

		public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

		public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

		public int getSweepCount() {
		return sweepCount;
	}

	public void setSweepCount(int sweepCount) {
		this.sweepCount = sweepCount;
	}

		public int getIsSucceed() {
		return isSucceed;
	}

	public void setIsSucceed(int isSucceed) {
		this.isSucceed = isSucceed;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.instanceId = readInt(buf, false);
		this.type = readInt(buf, false);
		this.surplusNum = readInt(buf, false);
		this.freshTime = readInt(buf, false);
		this.hp = readLong(buf);
		this.num = readInt(buf, false);
		this.ownerName = readString(buf);
		this.state = readInt(buf, false);
		this.sweepCount = readInt(buf, false);
		this.isSucceed = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, type, false);
		this.writeInt(buf, surplusNum, false);
		this.writeInt(buf, freshTime, false);
		this.writeLong(buf, hp);
		this.writeInt(buf, num, false);
		this.writeString(buf, ownerName);
		this.writeInt(buf, state, false);
		this.writeInt(buf, sweepCount, false);
		this.writeInt(buf, isSucceed, false);
		return true;
	}
}
