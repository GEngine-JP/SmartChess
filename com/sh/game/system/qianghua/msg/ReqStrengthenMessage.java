package com.sh.game.system.qianghua.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求强化</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqStrengthenMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqStrengthenMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 12003;
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
	 * 装备位置
	 */
	private int index;
	/**
	 * 1保护
	 */
	private int isProtect;

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

		public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

		public int getIsProtect() {
		return isProtect;
	}

	public void setIsProtect(int isProtect) {
		this.isProtect = isProtect;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.index = readInt(buf, false);
		this.isProtect = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, index, false);
		this.writeInt(buf, isProtect, false);
		return true;
	}
}
