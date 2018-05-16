package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求升级光翼资质</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqLevelUpTalentMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqLevelUpTalentMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18009;
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
	 * 资质类型
	 */
	private int cls;

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

		public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.cls = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, cls, false);
		return true;
	}
}
