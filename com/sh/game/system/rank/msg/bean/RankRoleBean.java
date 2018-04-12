package com.sh.game.system.rank.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class RankRoleBean extends KryoBean {

	/**
	 * 玩家id
	 */
	private long id;

	/**
	 * 成员名称
	 */
	private String name;

	/**
	 * 成员职业
	 */
	private int career;

	/**
	 * 性别
	 */
	private int sex;

	/**
	 * 衣服
	 */
	private int cloth;

	/**
	 * 武器
	 */
	private int weapon;

	/**
	 * 翅膀
	 */
	private int wing;

	/**
	 * 称号
	 */
	private int fashionTitle;

	/**
	 * 衣服
	 */
	private int fashionCloth;

	/**
	 * 翅膀
	 */
	private int fashionWing;

	/**
	 * 武器
	 */
	private int fashionWeapon;

	/**
	 * 穿戴的寶物id
	 */
	private int treasure;


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

	
	public int getFashionTitle() {
		return fashionTitle;
	}

	public void setFashionTitle(int fashionTitle) {
		this.fashionTitle = fashionTitle;
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

	
	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.id = readLong(buf);
		this.name = readString(buf);
		this.career = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.cloth = readInt(buf, false);
		this.weapon = readInt(buf, false);
		this.wing = readInt(buf, false);
		this.fashionTitle = readInt(buf, false);
		this.fashionCloth = readInt(buf, false);
		this.fashionWing = readInt(buf, false);
		this.fashionWeapon = readInt(buf, false);
		this.treasure = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, id);
		this.writeString(buf, name);
		this.writeInt(buf, career, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, cloth, false);
		this.writeInt(buf, weapon, false);
		this.writeInt(buf, wing, false);
		this.writeInt(buf, fashionTitle, false);
		this.writeInt(buf, fashionCloth, false);
		this.writeInt(buf, fashionWing, false);
		this.writeInt(buf, fashionWeapon, false);
		this.writeInt(buf, treasure, false);

		return true;
	}
}

