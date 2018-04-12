package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回升级结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResBackLingBaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResBackLingBaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13019;
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

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 剩余经验
	 */
	private int restExp;


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

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public int getRestExp() {
		return restExp;
	}

	public void setRestExp(int restExp) {
		this.restExp = restExp;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.itemId = readInt(buf, false);
		this.level = readInt(buf, false);
		this.restExp = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, itemId, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, restExp, false);

		return true;
	}
}

