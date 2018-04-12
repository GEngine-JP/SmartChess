package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionBossInfo extends KryoBean {

	/**
	 * 副本唯一
	 */
	private int instanceUniqueId;

	/**
	 * 副本
	 */
	private int instanceId;

	/**
	 * 怪物当前血量
	 */
	private long monsterHp;

	/**
	 * 副本归属者id
	 */
	private long ownerId;

	/**
	 * 副本归属者名字
	 */
	private String ownerName;


	public int getInstanceUniqueId() {
		return instanceUniqueId;
	}

	public void setInstanceUniqueId(int instanceUniqueId) {
		this.instanceUniqueId = instanceUniqueId;
	}

	
	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	
	public long getMonsterHp() {
		return monsterHp;
	}

	public void setMonsterHp(long monsterHp) {
		this.monsterHp = monsterHp;
	}

	
	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.instanceUniqueId = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.monsterHp = readLong(buf);
		this.ownerId = readLong(buf);
		this.ownerName = readString(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, instanceUniqueId, false);
		this.writeInt(buf, instanceId, false);
		this.writeLong(buf, monsterHp);
		this.writeLong(buf, ownerId);
		this.writeString(buf, ownerName);

		return true;
	}
}

