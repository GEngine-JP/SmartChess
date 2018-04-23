package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class UnionRedPackRecordBean extends KryoBean {

	/**
	 * 发送者名字
	 */
	private String sender;
	/**
	 * 抢夺者
	 */
	private String robber;
	/**
	 * 抢夺者职业
	 */
	private int robberCareer;
	/**
	 * 抢夺者性别
	 */
	private int robberSex;
	/**
	 * 发送者职业
	 */
	private int senderCareer;
	/**
	 * 发送者性别
	 */
	private int sendSex;
	/**
	 * 抢红包的时间
	 */
	private int robTime;
	/**
	 * 元宝
	 */
	private int money;
	/**
	 * 是否是最佳
	 */
	private boolean isBest;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

		public String getRobber() {
		return robber;
	}

	public void setRobber(String robber) {
		this.robber = robber;
	}

		public int getRobberCareer() {
		return robberCareer;
	}

	public void setRobberCareer(int robberCareer) {
		this.robberCareer = robberCareer;
	}

		public int getRobberSex() {
		return robberSex;
	}

	public void setRobberSex(int robberSex) {
		this.robberSex = robberSex;
	}

		public int getSenderCareer() {
		return senderCareer;
	}

	public void setSenderCareer(int senderCareer) {
		this.senderCareer = senderCareer;
	}

		public int getSendSex() {
		return sendSex;
	}

	public void setSendSex(int sendSex) {
		this.sendSex = sendSex;
	}

		public int getRobTime() {
		return robTime;
	}

	public void setRobTime(int robTime) {
		this.robTime = robTime;
	}

		public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

		public boolean getIsBest() {
		return isBest;
	}

	public void setIsBest(boolean isBest) {
		this.isBest = isBest;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.sender = readString(buf);
		this.robber = readString(buf);
		this.robberCareer = readInt(buf, false);
		this.robberSex = readInt(buf, false);
		this.senderCareer = readInt(buf, false);
		this.sendSex = readInt(buf, false);
		this.robTime = readInt(buf, false);
		this.money = readInt(buf, false);
		this.isBest = readBoolean(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeString(buf, sender);
		this.writeString(buf, robber);
		this.writeInt(buf, robberCareer, false);
		this.writeInt(buf, robberSex, false);
		this.writeInt(buf, senderCareer, false);
		this.writeInt(buf, sendSex, false);
		this.writeInt(buf, robTime, false);
		this.writeInt(buf, money, false);
		this.writeBoolean(buf, isBest);
		return true;
	}
}
