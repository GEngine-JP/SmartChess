package com.sh.game.system.hero.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.hero.msg.bean.HeroAttribute;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class HerosAttributeBean extends KryoBean {

	/**
	 * 英雄属性
	 */
	private HeroAttribute heroAttribute;

	/**
	 * 英雄id
	 */
	private long heroId;

	/**
	 * 战斗力
	 */
	private int power;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 职业
	 */
	private int career;

	/**
	 * 性别
	 */
	private int sex;

	/**
	 * 编号
	 */
	private int number;


	public HeroAttribute getHeroAttribute() {
		return heroAttribute;
	}

	public void setHeroAttribute(HeroAttribute heroAttribute) {
		this.heroAttribute = heroAttribute;
	}

	
	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		if (readByte(buf) != 0) {
			HeroAttribute heroAttribute = new HeroAttribute();
			heroAttribute.read(buf);
			this.heroAttribute = heroAttribute;
		}
		this.heroId = readLong(buf);
		this.power = readInt(buf, false);
		this.name = readString(buf);
		this.career = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.number = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeBean(buf, heroAttribute);
		this.writeLong(buf, heroId);
		this.writeInt(buf, power, false);
		this.writeString(buf, name);
		this.writeInt(buf, career, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, number, false);

		return true;
	}
}

