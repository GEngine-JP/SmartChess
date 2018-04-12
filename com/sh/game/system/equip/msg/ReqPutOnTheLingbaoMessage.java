package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求穿上指定灵宝</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqPutOnTheLingbaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOnTheLingbaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13022;
	}
	
	/**
	 * 1主角 2英雄
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

	/**
	 * 唯一id
	 */
	private long equipId;


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

	
	public long getEquipId() {
		return equipId;
	}

	public void setEquipId(long equipId) {
		this.equipId = equipId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.index = readInt(buf, false);
		this.equipId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, index, false);
		this.writeLong(buf, equipId);

		return true;
	}
}

