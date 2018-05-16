package com.sh.game.system.xinfa.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求升级心法</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLevelUpHeartMethodMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpHeartMethodMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 58002;
	}
	
	/**
	 * 1角色2英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 心法位置
	 */
	private int position;
	/**
	 * 心法id
	 */
	private int methodId;

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

		public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

		public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.position = readInt(buf, false);
		this.methodId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, position, false);
		this.writeInt(buf, methodId, false);
		return true;
	}
}
