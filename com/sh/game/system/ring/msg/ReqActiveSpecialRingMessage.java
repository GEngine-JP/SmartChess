package com.sh.game.system.ring.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求激活特戒</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqActiveSpecialRingMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqActiveSpecialRingMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 53005;
	}
	
	/**
	 * 特戒类型
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色0英雄1
	 */
	private int owner;

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

		public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.owner = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, owner, false);
		return true;
	}
}
