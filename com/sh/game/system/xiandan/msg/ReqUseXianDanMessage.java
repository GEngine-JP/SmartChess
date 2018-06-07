package com.sh.game.system.xiandan.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求使用仙丹</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqUseXianDanMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseXianDanMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 64001;
	}
	
	/**
	 * 类型 1 角色 2 英雄
	 */
	private int type;
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 仙丹id
	 */
	private int xianDanId;

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

		public int getXianDanId() {
		return xianDanId;
	}

	public void setXianDanId(int xianDanId) {
		this.xianDanId = xianDanId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.xianDanId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, xianDanId, false);
		return true;
	}
}
