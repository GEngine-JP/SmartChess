package com.sh.game.system.ring.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求升级特戒指定部位</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUpLevelRingPartMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUpLevelRingPartMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 53003;
	}
	
	/**
	 * 特戒类型
	 */
	private int type;
	/**
	 * 部位位置
	 */
	private int position;
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

		public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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
		this.position = readInt(buf, false);
		this.heroId = readLong(buf);
		this.owner = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeInt(buf, position, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, owner, false);
		return true;
	}
}
