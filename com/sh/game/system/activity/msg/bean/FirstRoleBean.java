package com.sh.game.system.activity.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class FirstRoleBean extends KryoBean {

	/**
	 * 职业
	 */
	private int sex;

	/**
	 * 性别
	 */
	private int career;

	/**
	 * 武器
	 */
	private int cloth;

	/**
	 * 衣服
	 */
	private int weapon;

	/**
	 * 翅膀
	 */
	private int wing;

	/**
	 * 时装衣服
	 */
	private int fashionCloth;

	/**
	 * 时装翅膀
	 */
	private int fashionWing;

	/**
	 * 时装武器
	 */
	private int fashionWeapon;


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

	
	public int getCloth() {
		return cloth;
	}

	public void setCloth(int cloth) {
		this.cloth = cloth;
	}

	
	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	
	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}

	
	public int getFashionCloth() {
		return fashionCloth;
	}

	public void setFashionCloth(int fashionCloth) {
		this.fashionCloth = fashionCloth;
	}

	
	public int getFashionWing() {
		return fashionWing;
	}

	public void setFashionWing(int fashionWing) {
		this.fashionWing = fashionWing;
	}

	
	public int getFashionWeapon() {
		return fashionWeapon;
	}

	public void setFashionWeapon(int fashionWeapon) {
		this.fashionWeapon = fashionWeapon;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.cloth = readInt(buf, false);
		this.weapon = readInt(buf, false);
		this.wing = readInt(buf, false);
		this.fashionCloth = readInt(buf, false);
		this.fashionWing = readInt(buf, false);
		this.fashionWeapon = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, cloth, false);
		this.writeInt(buf, weapon, false);
		this.writeInt(buf, wing, false);
		this.writeInt(buf, fashionCloth, false);
		this.writeInt(buf, fashionWing, false);
		this.writeInt(buf, fashionWeapon, false);

		return true;
	}
}

