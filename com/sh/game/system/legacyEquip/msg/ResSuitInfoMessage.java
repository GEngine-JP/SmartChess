package com.sh.game.system.legacyEquip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送套装信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSuitInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSuitInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 19012;
	}
	
	/**
	 * 套装id
	 */
	private int suitId;
	/**
	 * 当前个数
	 */
	private int nowCount;
	/**
	 * 类型 1 角色 2 英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;

	public int getSuitId() {
		return suitId;
	}

	public void setSuitId(int suitId) {
		this.suitId = suitId;
	}

		public int getNowCount() {
		return nowCount;
	}

	public void setNowCount(int nowCount) {
		this.nowCount = nowCount;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.suitId = readInt(buf, false);
		this.nowCount = readInt(buf, false);
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, suitId, false);
		this.writeInt(buf, nowCount, false);
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
