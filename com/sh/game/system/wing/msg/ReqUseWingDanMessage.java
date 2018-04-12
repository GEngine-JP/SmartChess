package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求使用光翼直升丹</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqUseWingDanMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseWingDanMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18011;
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
	 * 直升丹id
	 */
	private int danId;


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

	
	public int getDanId() {
		return danId;
	}

	public void setDanId(int danId) {
		this.danId = danId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.danId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, danId, false);

		return true;
	}
}

