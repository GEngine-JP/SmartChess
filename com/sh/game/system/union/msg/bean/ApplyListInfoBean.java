package com.sh.game.system.union.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ApplyListInfoBean extends KryoBean {

	/**
	 * 玩家id
	 */
	private long id;

	/**
	 * 申请玩家角色
	 */
	private String memberName;

	/**
	 * 申请玩家职业
	 */
	private int career;

	/**
	 * 申请玩家等级
	 */
	private int memberLevel;

	/**
	 * 申请者战斗力
	 */
	private int fightValue;

	/**
	 * 玩家性别
	 */
	private int sex;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	
	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readLong(buf);
		this.memberName = readString(buf);
		this.career = readInt(buf, false);
		this.memberLevel = readInt(buf, false);
		this.fightValue = readInt(buf, false);
		this.sex = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, id);
		this.writeString(buf, memberName);
		this.writeInt(buf, career, false);
		this.writeInt(buf, memberLevel, false);
		this.writeInt(buf, fightValue, false);
		this.writeInt(buf, sex, false);

		return true;
	}
}

