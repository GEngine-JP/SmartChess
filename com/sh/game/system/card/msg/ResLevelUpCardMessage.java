package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回升级卡片</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLevelUpCardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLevelUpCardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51007;
	}
	
	/**
	 * 1角色 2英雄 3背包
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 唯一id
	 */
	private long uniqueId;
	/**
	 * 道具id
	 */
	private int itemId;

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

		public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

		public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.uniqueId = readLong(buf);
		this.itemId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeLong(buf, uniqueId);
		this.writeInt(buf, itemId, false);
		return true;
	}
}
