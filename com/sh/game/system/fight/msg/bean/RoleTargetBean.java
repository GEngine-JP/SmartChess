package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class RoleTargetBean extends KryoBean {

	/**
	 * 成员id
	 */
	private long memberId;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 性别 1男2女
	 */
	private int sex;
	/**
	 * 血量
	 */
	private long hp;
	/**
	 * 血量
	 */
	private long maxHp;
	/**
	 * 是否相同帮会 1相同
	 */
	private int isSameUnion;
	/**
	 * 是否属于皇宫归属权行会1是
	 */
	private int isPalaceOwner;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

		public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

		public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

		public long getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(long maxHp) {
		this.maxHp = maxHp;
	}

		public int getIsSameUnion() {
		return isSameUnion;
	}

	public void setIsSameUnion(int isSameUnion) {
		this.isSameUnion = isSameUnion;
	}

		public int getIsPalaceOwner() {
		return isPalaceOwner;
	}

	public void setIsPalaceOwner(int isPalaceOwner) {
		this.isPalaceOwner = isPalaceOwner;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.memberId = readLong(buf);
		this.career = readInt(buf, false);
		this.name = readString(buf);
		this.sex = readInt(buf, false);
		this.hp = readLong(buf);
		this.maxHp = readLong(buf);
		this.isSameUnion = readInt(buf, false);
		this.isPalaceOwner = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, memberId);
		this.writeInt(buf, career, false);
		this.writeString(buf, name);
		this.writeInt(buf, sex, false);
		this.writeLong(buf, hp);
		this.writeLong(buf, maxHp);
		this.writeInt(buf, isSameUnion, false);
		this.writeInt(buf, isPalaceOwner, false);
		return true;
	}
}
