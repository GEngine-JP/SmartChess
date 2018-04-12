package com.sh.game.system.role.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class PetBean extends KryoBean {

	/**
	 * 宠物id
	 */
	private long id;

	/**
	 * 1玩家 2 英雄
	 */
	private int mater;

	/**
	 * 1 神兽 2 月灵
	 */
	private int type;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public int getMater() {
		return mater;
	}

	public void setMater(int mater) {
		this.mater = mater;
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readLong(buf);
		this.mater = readInt(buf, false);
		this.type = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, id);
		this.writeInt(buf, mater, false);
		this.writeInt(buf, type, false);

		return true;
	}
}

