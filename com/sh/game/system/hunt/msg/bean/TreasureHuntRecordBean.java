package com.sh.game.system.hunt.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class TreasureHuntRecordBean extends KryoBean {

	/**
	 * 玩家id
	 */
	private long id;
	/**
	 * 宝物id
	 */
	private int itemId;
	/**
	 * 寻宝玩家名
	 */
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

		public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.id = readLong(buf);
		this.itemId = readInt(buf, false);
		this.name = readString(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, id);
		this.writeInt(buf, itemId, false);
		this.writeString(buf, name);
		return true;
	}
}
