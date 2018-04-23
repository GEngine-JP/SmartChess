package com.sh.game.system.shenzhu.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求铸造</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGodPlateMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGodPlateMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 47002;
	}
	
	/**
	 * 类型 1角色 2英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;

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

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		return true;
	}
}
