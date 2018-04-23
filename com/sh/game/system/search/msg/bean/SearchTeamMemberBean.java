package com.sh.game.system.search.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class SearchTeamMemberBean extends KryoBean {

	/**
	 * 1 玩家 2 英雄战 3 英雄法 4 英雄道 5宠物
	 */
	private int type;
	/**
	 * 成员id
	 */
	private long memberId;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * bossId
	 */
	private int bossId;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 转生
	 */
	private int rein;
	/**
	 * 性别 1男2女
	 */
	private int sex;
	/**
	 * 血量
	 */
	private long hp;
	/**
	 * 最大血量
	 */
	private long maxHp;
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
	/**
	 * 时装称号
	 */
	private int fashionTitle;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

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

		public int getBossId() {
		return bossId;
	}

	public void setBossId(int bossId) {
		this.bossId = bossId;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getRein() {
		return rein;
	}

	public void setRein(int rein) {
		this.rein = rein;
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

		public int getFashionTitle() {
		return fashionTitle;
	}

	public void setFashionTitle(int fashionTitle) {
		this.fashionTitle = fashionTitle;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.memberId = readLong(buf);
		this.career = readInt(buf, false);
		this.bossId = readInt(buf, false);
		this.name = readString(buf);
		this.level = readInt(buf, false);
		this.rein = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.hp = readLong(buf);
		this.maxHp = readLong(buf);
		this.cloth = readInt(buf, false);
		this.weapon = readInt(buf, false);
		this.wing = readInt(buf, false);
		this.fashionCloth = readInt(buf, false);
		this.fashionWing = readInt(buf, false);
		this.fashionWeapon = readInt(buf, false);
		this.fashionTitle = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, memberId);
		this.writeInt(buf, career, false);
		this.writeInt(buf, bossId, false);
		this.writeString(buf, name);
		this.writeInt(buf, level, false);
		this.writeInt(buf, rein, false);
		this.writeInt(buf, sex, false);
		this.writeLong(buf, hp);
		this.writeLong(buf, maxHp);
		this.writeInt(buf, cloth, false);
		this.writeInt(buf, weapon, false);
		this.writeInt(buf, wing, false);
		this.writeInt(buf, fashionCloth, false);
		this.writeInt(buf, fashionWing, false);
		this.writeInt(buf, fashionWeapon, false);
		this.writeInt(buf, fashionTitle, false);
		return true;
	}
}
