package com.sh.game.system.card.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送卡片套装信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCardSuitMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCardSuitMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 51008;
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
	 * 套装id
	 */
	private int suitId;


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

	
	public int getSuitId() {
		return suitId;
	}

	public void setSuitId(int suitId) {
		this.suitId = suitId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.suitId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, suitId, false);

		return true;
	}
}

