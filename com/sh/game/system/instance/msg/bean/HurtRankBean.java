package com.sh.game.system.instance.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class HurtRankBean extends KryoBean {

	/**
	 * 角色id
	 */
	private long roleId;

	/**
	 * 玩家名
	 */
	private String name;

	/**
	 * 玩家名次
	 */
	private int rank;

	/**
	 * 伤害
	 */
	private long hurt;


	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public long getHurt() {
		return hurt;
	}

	public void setHurt(long hurt) {
		this.hurt = hurt;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleId = readLong(buf);
		this.name = readString(buf);
		this.rank = readInt(buf, false);
		this.hurt = readLong(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, roleId);
		this.writeString(buf, name);
		this.writeInt(buf, rank, false);
		this.writeLong(buf, hurt);

		return true;
	}
}

