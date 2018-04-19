package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求脱下卡片</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqPutOffCardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqPutOffCardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51004;
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
	 * 位置1、2、3
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

