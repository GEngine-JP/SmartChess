package com.sh.game.system.back.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class AutoBanBean extends KryoBean {

	/**
	 * 玩家uid
	 */
	private long uid;
	/**
	 * 解禁时间
	 */
	private int unBanTime;
	/**
	 * 封禁原因
	 */
	private String banReason;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

		public int getUnBanTime() {
		return unBanTime;
	}

	public void setUnBanTime(int unBanTime) {
		this.unBanTime = unBanTime;
	}

		public String getBanReason() {
		return banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.uid = readLong(buf);
		this.unBanTime = readInt(buf, false);
		this.banReason = readString(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, uid);
		this.writeInt(buf, unBanTime, false);
		this.writeString(buf, banReason);
		return true;
	}
}
