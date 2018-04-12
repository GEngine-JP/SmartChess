package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class UnionChallengeRank extends KryoBean {

	/**
	 * 角色名
	 */
	private String roleName;

	/**
	 * 战斗力
	 */
	private int fightValue;

	/**
	 * 当前关卡
	 */
	private int floor;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.roleName = readString(buf);
		this.fightValue = readInt(buf, false);
		this.floor = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeString(buf, roleName);
		this.writeInt(buf, fightValue, false);
		this.writeInt(buf, floor, false);

		return true;
	}
}

