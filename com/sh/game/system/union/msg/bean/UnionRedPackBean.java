package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionRedPackBean extends KryoBean {

	/**
	 * 发送者id
	 */
	private long uid;

	/**
	 * 发送者名字
	 */
	private String name;

	/**
	 * 发送者职业
	 */
	private int senderCareer;

	/**
	 * 发送者性别
	 */
	private int sendSex;

	/**
	 * 红包id
	 */
	private long redPackId;

	/**
	 * 元宝
	 */
	private int money;

	/**
	 * 是否已领取
	 */
	private boolean isGet;

	/**
	 * 是否为空包(被领完)
	 */
	private boolean isNull;

	/**
	 * 祝福语
	 */
	private String content;

	/**
	 * 发送时间
	 */
	private int sendTime;


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	public long getRedPackId() {
		return redPackId;
	}

	public void setRedPackId(long redPackId) {
		this.redPackId = redPackId;
	}

	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public boolean getIsGet() {
		return isGet;
	}

	public void setIsGet(boolean isGet) {
		this.isGet = isGet;
	}

	
	public boolean getIsNull() {
		return isNull;
	}

	public void setIsNull(boolean isNull) {
		this.isNull = isNull;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public int getSendTime() {
		return sendTime;
	}

	public void setSendTime(int sendTime) {
		this.sendTime = sendTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readLong(buf);
		this.name = readString(buf);
		this.senderCareer = readInt(buf, false);
		this.sendSex = readInt(buf, false);
		this.redPackId = readLong(buf);
		this.money = readInt(buf, false);
		this.isGet = readBoolean(buf);
		this.isNull = readBoolean(buf);
		this.content = readString(buf);
		this.sendTime = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);
		this.writeString(buf, name);
		this.writeInt(buf, senderCareer, false);
		this.writeInt(buf, sendSex, false);
		this.writeLong(buf, redPackId);
		this.writeInt(buf, money, false);
		this.writeBoolean(buf, isGet);
		this.writeBoolean(buf, isNull);
		this.writeString(buf, content);
		this.writeInt(buf, sendTime, false);

		return true;
	}
}

