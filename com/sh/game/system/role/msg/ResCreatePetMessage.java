package com.sh.game.system.role.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送玩家宠物信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCreatePetMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCreatePetMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 8013;
	}
	
	/**
	 * 宠物id
	 */
	private long petId;

	/**
	 * 1玩家 2英雄
	 */
	private int master;

	/**
	 * 1 神兽 2 月灵
	 */
	private int type;


	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	
	public int getMaster() {
		return master;
	}

	public void setMaster(int master) {
		this.master = master;
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.petId = readLong(buf);
		this.master = readInt(buf, false);
		this.type = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, petId);
		this.writeInt(buf, master, false);
		this.writeInt(buf, type, false);

		return true;
	}
}

