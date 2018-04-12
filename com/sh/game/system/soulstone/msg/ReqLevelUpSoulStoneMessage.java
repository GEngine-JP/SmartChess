package com.sh.game.system.soulstone.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求进阶魂石</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLevelUpSoulStoneMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpSoulStoneMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 35013;
	}
	
	/**
	 * 类型 1角色 2英雄
	 */
	private int type;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 魂石类型
	 */
	private int stoneType;


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

	
	public int getStoneType() {
		return stoneType;
	}

	public void setStoneType(int stoneType) {
		this.stoneType = stoneType;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.stoneType = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, stoneType, false);

		return true;
	}
}

