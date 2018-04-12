package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求升级光翼</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqLevelUpWingMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpWingMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18004;
	}
	
	/**
	 * 1角色光翼 2英雄光翼
	 */
	private int type;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 是否自动使用元宝购买羽毛
	 */
	private int autoUseMoney;


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

	
	public int getAutoUseMoney() {
		return autoUseMoney;
	}

	public void setAutoUseMoney(int autoUseMoney) {
		this.autoUseMoney = autoUseMoney;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.autoUseMoney = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, autoUseMoney, false);

		return true;
	}
}

