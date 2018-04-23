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

public class InstanceInfo extends KryoBean {

	/**
	 * 类型
	 */
	private int type;
	/**
	 * 总次数
	 */
	private int count;
	/**
	 * 剩余次数
	 */
	private int surplusNum;
	/**
	 * 下次刷新时间
	 */
	private int freshTime;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.count = readInt(buf, false);
		this.surplusNum = readInt(buf, false);
		this.freshTime = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, count, false);
		this.writeInt(buf, surplusNum, false);
		this.writeInt(buf, freshTime, false);
		return true;
	}
}
