package com.sh.game.system.robtreasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求灵宝精炼</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLingBaoRefineMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLingBaoRefineMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 50023;
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

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.uniqueId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeLong(buf, uniqueId);

		return true;
	}
}

