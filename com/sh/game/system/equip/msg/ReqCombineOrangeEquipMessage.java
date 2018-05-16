package com.sh.game.system.equip.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求合成橙色装备</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqCombineOrangeEquipMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCombineOrangeEquipMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 13018;
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
	 * 装备位置
	 */
	private int index;
	/**
	 * 装备id
	 */
	private int equipId;

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

		public int getEquipId() {
		return equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.heroId = readLong(buf);
		this.index = readInt(buf, false);
		this.equipId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, heroId);
		this.writeInt(buf, index, false);
		this.writeInt(buf, equipId, false);
		return true;
	}
}
