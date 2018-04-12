package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>聊天禁言</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBandChatMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBandChatMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43030;
	}
	
	/**
	 * 对象的uid
	 */
	private String uid;

	/**
	 * 禁言理由
	 */
	private String banReason;

	/**
	 * 禁聊时间(要禁言的秒数)
	 */
	private int bandTime;


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	
	public String getBanReason() {
		return banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

	
	public int getBandTime() {
		return bandTime;
	}

	public void setBandTime(int bandTime) {
		this.bandTime = bandTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readString(buf);
		this.banReason = readString(buf);
		this.bandTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, uid);
		this.writeString(buf, banReason);
		this.writeInt(buf, bandTime, false);

		return true;
	}
}

