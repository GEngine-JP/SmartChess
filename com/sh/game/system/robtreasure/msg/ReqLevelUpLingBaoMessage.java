package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>请求升级灵宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLevelUpLingBaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpLingBaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50016;
	}
	
	/**
	 * 1、玩家 2、英雄 3、背包
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
	 * 消耗灵宝唯一id
	 */
	private List<Long> equips = new ArrayList<Long>();

	/**
	 * 消耗经验灵宝id
	 */
	private List<Long> items = new ArrayList<Long>();


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

	
	public List<Long> getEquips() {
		return equips;
	}

	public void setEquips(List<Long> equips) {
		this.equips = equips;
	}

	public List<Long> getItems() {
		return items;
	}

	public void setItems(List<Long> items) {
		this.items = items;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.uniqueId = readLong(buf);
		int equipsLength = readShort(buf);
		for (int equipsI = 0; equipsI < equipsLength; equipsI++) {
			this.equips.add(this.readLong(buf));
		}

		int itemsLength = readShort(buf);
		for (int itemsI = 0; itemsI < itemsLength; itemsI++) {
			this.items.add(this.readLong(buf));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeLong(buf, uniqueId);
		writeShort(buf, this.equips.size());
		for (int equipsI = 0; equipsI < this.equips.size(); equipsI++) {
			this.writeLong(buf, this.equips.get(equipsI));
		}

		writeShort(buf, this.items.size());
		for (int itemsI = 0; itemsI < this.items.size(); itemsI++) {
			this.writeLong(buf, this.items.get(itemsI));
		}


		return true;
	}
}

