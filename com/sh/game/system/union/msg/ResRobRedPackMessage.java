package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.union.msg.bean.UnionRedPackRecordBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>抢红包返回</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResRobRedPackMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResRobRedPackMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23038;
	}
	
	/**
	 * 发送者名字
	 */
	private String sender;

	/**
	 * 发送者职业
	 */
	private int senderCareer;

	/**
	 * 发送者性别
	 */
	private int sendSex;

	/**
	 * 抢到的红包数量
	 */
	private int money;

	/**
	 * 已领取个数
	 */
	private int getCount;

	/**
	 * 总数
	 */
	private int maxCount;

	/**
	 * 已领取的红包
	 */
	private int getMoney;

	/**
	 * 红包的总金额
	 */
	private int maxMoney;

	/**
	 * 祝福语
	 */
	private String content;

	/**
	 * 红包记录列表
	 */
	private List<UnionRedPackRecordBean> unionRedPackRecordBean = new ArrayList<UnionRedPackRecordBean>();


	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
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

	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public int getGetCount() {
		return getCount;
	}

	public void setGetCount(int getCount) {
		this.getCount = getCount;
	}

	
	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	
	public int getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(int getMoney) {
		this.getMoney = getMoney;
	}

	
	public int getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(int maxMoney) {
		this.maxMoney = maxMoney;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public List<UnionRedPackRecordBean> getUnionRedPackRecordBean() {
		return unionRedPackRecordBean;
	}

	public void setUnionRedPackRecordBean(List<UnionRedPackRecordBean> unionRedPackRecordBean) {
		this.unionRedPackRecordBean = unionRedPackRecordBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.sender = readString(buf);
		this.senderCareer = readInt(buf, false);
		this.sendSex = readInt(buf, false);
		this.money = readInt(buf, false);
		this.getCount = readInt(buf, false);
		this.maxCount = readInt(buf, false);
		this.getMoney = readInt(buf, false);
		this.maxMoney = readInt(buf, false);
		this.content = readString(buf);
		int unionRedPackRecordBeanLength = readShort(buf);
		for (int unionRedPackRecordBeanI = 0; unionRedPackRecordBeanI < unionRedPackRecordBeanLength; unionRedPackRecordBeanI++) {
			if (readByte(buf) == 0) { 
				this.unionRedPackRecordBean.add(null);
			} else {
				UnionRedPackRecordBean unionRedPackRecordBean = new UnionRedPackRecordBean();
				unionRedPackRecordBean.read(buf);
				this.unionRedPackRecordBean.add(unionRedPackRecordBean);
			}
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, sender);
		this.writeInt(buf, senderCareer, false);
		this.writeInt(buf, sendSex, false);
		this.writeInt(buf, money, false);
		this.writeInt(buf, getCount, false);
		this.writeInt(buf, maxCount, false);
		this.writeInt(buf, getMoney, false);
		this.writeInt(buf, maxMoney, false);
		this.writeString(buf, content);
		writeShort(buf, this.unionRedPackRecordBean.size());
		for (int unionRedPackRecordBeanI = 0; unionRedPackRecordBeanI < this.unionRedPackRecordBean.size(); unionRedPackRecordBeanI++) {
			this.writeBean(buf, this.unionRedPackRecordBean.get(unionRedPackRecordBeanI));
		}


		return true;
	}
}

