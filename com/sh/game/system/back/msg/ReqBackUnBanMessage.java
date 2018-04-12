package com.sh.game.system.back.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>解禁ip或账号</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBackUnBanMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBackUnBanMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 43028;
	}
	
	/**
	 * 1账号 2ip
	 */
	private int banType;

	/**
	 * uid
	 */
	private String uid;


	public int getBanType() {
		return banType;
	}

	public void setBanType(int banType) {
		this.banType = banType;
	}

	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.banType = readInt(buf, false);
		this.uid = readString(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, banType, false);
		this.writeString(buf, uid);

		return true;
	}
}

