package com.sh.game.system.user.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>告知客户端进入游戏</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResEnterGameMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResEnterGameMessage() {
		this.queueId = 1;
	}
	
	@Override
	public int getId() {
		return 1006;
	}
	
	/**
	 * 玩家id
	 */
	private long uid;

	/**
	 * 玩家id的字符串
	 */
	private String uidStr;

	/**
	 * 服务器时间
	 */
	private long serverTime;


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public String getUidStr() {
		return uidStr;
	}

	public void setUidStr(String uidStr) {
		this.uidStr = uidStr;
	}

	
	public long getServerTime() {
		return serverTime;
	}

	public void setServerTime(long serverTime) {
		this.serverTime = serverTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uid = readLong(buf);
		this.uidStr = readString(buf);
		this.serverTime = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, uid);
		this.writeString(buf, uidStr);
		this.writeLong(buf, serverTime);

		return true;
	}
}

