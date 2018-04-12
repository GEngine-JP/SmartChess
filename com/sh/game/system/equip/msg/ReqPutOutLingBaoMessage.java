package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求脱灵宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqPutOutLingBaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOutLingBaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13020;
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
	 * 装备id
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
		this.itemId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, itemId, false);

		return true;
	}
}

