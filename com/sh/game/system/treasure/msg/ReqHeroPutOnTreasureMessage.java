package com.sh.game.system.treasure.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求穿戴宝物</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqHeroPutOnTreasureMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqHeroPutOnTreasureMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 14019;
	}
	
	/**
	 * 宝物类型 1.神弓 2.神斧 3.神剑 4.法宝
	 */
	private int type;
	/**
	 * heroId
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
