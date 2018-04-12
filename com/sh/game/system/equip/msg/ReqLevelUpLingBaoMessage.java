package com.sh.game.system.equip.msg;

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
		return 13018;
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
	 * 升级消耗唯一id
	 */
	private List<Long> cost = new ArrayList<Long>();


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

	
	public List<Long> getCost() {
		return cost;
	}

	public void setCost(List<Long> cost) {
		this.cost = cost;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.uniqueId = readLong(buf);
		int costLength = readShort(buf);
		for (int costI = 0; costI < costLength; costI++) {
			this.cost.add(this.readLong(buf));
		}


		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeLong(buf, uniqueId);
		writeShort(buf, this.cost.size());
		for (int costI = 0; costI < this.cost.size(); costI++) {
			this.writeLong(buf, this.cost.get(costI));
		}


		return true;
	}
}

