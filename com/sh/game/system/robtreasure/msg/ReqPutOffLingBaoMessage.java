package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求脱灵宝</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPutOffLingBaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOffLingBaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50018;
	}
	
	/**
	 * 1、玩家 2、英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 装备位置
	 */
	private int index;

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

		public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.index = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, index, false);
		return true;
	}
}
