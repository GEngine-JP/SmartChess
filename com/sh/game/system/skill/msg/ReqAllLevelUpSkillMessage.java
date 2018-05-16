package com.sh.game.system.skill.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求全部升级技能</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqAllLevelUpSkillMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqAllLevelUpSkillMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 9004;
	}
	
	/**
	 * 英雄id
	 */
	private long heroId;
	/**
	 * 角色1英雄2
	 */
	private int type;

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

		this.heroId = readLong(buf);
		this.type = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, heroId);
		this.writeInt(buf, type, false);
		return true;
	}
}
