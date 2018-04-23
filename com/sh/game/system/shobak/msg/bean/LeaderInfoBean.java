package com.sh.game.system.shobak.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class LeaderInfoBean extends KryoBean {

	/**
	 * 翅膀id
	 */
	private int windId;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * 玩家名字
	 */
	private String name;
	/**
	 * 行会
	 */
	private String unionName;
	/**
	 * 称号
	 */
	private int fashionTitle;
	/**
	 * 衣服
	 */
	private int fashionCloth;
	/**
	 * 武器
	 */
	private int fashionWeapon;
	/**
	 * 翅膀
	 */
	private int fashionWing;
	/**
	 * 装备衣服
	 */
	private int cloth;
	/**
	 * 装备武器
	 */
	private int weapon;

	public int getWindId() {
		return windId;
	}

	public void setWindId(int windId) {
		this.windId = windId;
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

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
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

		public int getFashionWeapon() {
		return fashionWeapon;
	}

	public void setFashionWeapon(int fashionWeapon) {
		this.fashionWeapon = fashionWeapon;
	}

		public int getFashionWing() {
		return fashionWing;
	}

	public void setFashionWing(int fashionWing) {
		this.fashionWing = fashionWing;
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

	
	@Override
	public boolean read(KryoInput buf) {

		this.windId = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.name = readString(buf);
		this.unionName = readString(buf);
		this.fashionTitle = readInt(buf, false);
		this.fashionCloth = readInt(buf, false);
		this.fashionWeapon = readInt(buf, false);
		this.fashionWing = readInt(buf, false);
		this.cloth = readInt(buf, false);
		this.weapon = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, windId, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeString(buf, name);
		this.writeString(buf, unionName);
		this.writeInt(buf, fashionTitle, false);
		this.writeInt(buf, fashionCloth, false);
		this.writeInt(buf, fashionWeapon, false);
		this.writeInt(buf, fashionWing, false);
		this.writeInt(buf, cloth, false);
		this.writeInt(buf, weapon, false);
		return true;
	}
}
