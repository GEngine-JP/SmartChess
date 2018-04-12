package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求一键激活经脉</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqOneKeyActiveVeinMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqOneKeyActiveVeinMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22006;
	}
	
	/**
	 * 英雄id
	 */
	private long heroId;


	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.heroId = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, heroId);

		return true;
	}
}

