package com.sh.game.system.shenzhu.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>神铸信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResGodplateInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResGodplateInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 47001;
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
	 * 神铸配置id
	 */
	private int configId;


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

	
	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.configId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, configId, false);

		return true;
	}
}

