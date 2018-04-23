package com.sh.game.system.refine.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求精炼</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqRefineMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqRefineMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 55002;
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
	private int equipSlot;

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

		public int getEquipSlot() {
		return equipSlot;
	}

	public void setEquipSlot(int equipSlot) {
		this.equipSlot = equipSlot;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.equipSlot = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, equipSlot, false);
		return true;
	}
}
