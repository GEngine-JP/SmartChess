package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求穿戴卡片</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPutOnCardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOnCardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51002;
	}
	
	/**
	 * 1角色 2英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 要穿戴的位置1、2、3
	 */
	private int index;
	/**
	 * 卡片唯一id
	 */
	private long uniqueId;

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

		public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.index = readInt(buf, false);
		this.uniqueId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, index, false);
		this.writeLong(buf, uniqueId);
		return true;
	}
}
