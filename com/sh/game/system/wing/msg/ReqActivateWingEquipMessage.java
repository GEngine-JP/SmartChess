package com.sh.game.system.wing.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求激活光翼装备</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqActivateWingEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqActivateWingEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 18007;
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
	 * 光翼装备类型
	 */
	private int wingEquipType;


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

	
	public int getWingEquipType() {
		return wingEquipType;
	}

	public void setWingEquipType(int wingEquipType) {
		this.wingEquipType = wingEquipType;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.wingEquipType = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, wingEquipType, false);

		return true;
	}
}

