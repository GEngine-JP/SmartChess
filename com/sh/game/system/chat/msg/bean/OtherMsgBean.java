package com.sh.game.system.chat.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class OtherMsgBean extends KryoBean {

	/**
	 * 私聊的时候的目标，其他情况发0
	 */
	private long targetUid;

	/**
	 * 发送者id
	 */
	private long sendUid;

	/**
	 * 发送者名字
	 */
	private String sendName;

	/**
	 * 接收者id
	 */
	private long receivedUid;

	/**
	 * 接受者名字
	 */
	private String receivedName;

	/**
	 * 称号
	 */
	private int titleId;

	/**
	 * vip等级
	 */
	private int vipLevel;

	/**
	 * 是否有月卡
	 */
	private boolean isMonthCard;


	public long getTargetUid() {
		return targetUid;
	}

	public void setTargetUid(long targetUid) {
		this.targetUid = targetUid;
	}

	
	public long getSendUid() {
		return sendUid;
	}

	public void setSendUid(long sendUid) {
		this.sendUid = sendUid;
	}

	
	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	
	public long getReceivedUid() {
		return receivedUid;
	}

	public void setReceivedUid(long receivedUid) {
		this.receivedUid = receivedUid;
	}

	
	public String getReceivedName() {
		return receivedName;
	}

	public void setReceivedName(String receivedName) {
		this.receivedName = receivedName;
	}

	
	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	
	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	
	public boolean getIsMonthCard() {
		return isMonthCard;
	}

	public void setIsMonthCard(boolean isMonthCard) {
		this.isMonthCard = isMonthCard;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetUid = readLong(buf);
		this.sendUid = readLong(buf);
		this.sendName = readString(buf);
		this.receivedUid = readLong(buf);
		this.receivedName = readString(buf);
		this.titleId = readInt(buf, false);
		this.vipLevel = readInt(buf, false);
		this.isMonthCard = readBoolean(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, targetUid);
		this.writeLong(buf, sendUid);
		this.writeString(buf, sendName);
		this.writeLong(buf, receivedUid);
		this.writeString(buf, receivedName);
		this.writeInt(buf, titleId, false);
		this.writeInt(buf, vipLevel, false);
		this.writeBoolean(buf, isMonthCard);

		return true;
	}
}

