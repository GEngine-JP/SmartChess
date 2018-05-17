package com.sh.game.system.xinfa.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送心法变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResHeartMethodChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResHeartMethodChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 58003;
	}
	
	/**
	 * 心法位置
	 */
	private int position;
	/**
	 * 心法id
	 */
	private int methodId;
	/**
	 * 心法等级
	 */
	private int level;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色1英雄2
	 */
	private int type;

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

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

		public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.position = readInt(buf, false);
		this.methodId = readInt(buf, false);
		this.level = readInt(buf, false);
		this.heroId = readLong(buf);
		this.type = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, position, false);
		this.writeInt(buf, methodId, false);
		this.writeInt(buf, level, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, type, false);
		return true;
	}
}
