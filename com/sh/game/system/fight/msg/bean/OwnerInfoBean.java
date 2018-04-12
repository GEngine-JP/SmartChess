package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class OwnerInfoBean extends KryoBean {

	/**
	 * 玩家id
	 */
	private long id;

	/**
	 * 玩家名
	 */
	private String name;

	/**
	 * 性别
	 */
	private int sex;

	/**
	 * 职业
	 */
	private int career;

	/**
	 * 战力
	 */
	private int fightValue;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	
	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	
	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readLong(buf);
		this.name = readString(buf);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.fightValue = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, id);
		this.writeString(buf, name);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, fightValue, false);

		return true;
	}
}

