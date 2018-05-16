package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求穿戴光翼装备</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqPutOnWingEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOnWingEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18007;
	}
	
	/**
	 * 1角色光翼 2英雄光翼
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 位置
	 */
	private int index;
	/**
	 * 唯一id
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
