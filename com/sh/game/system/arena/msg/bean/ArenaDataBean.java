package com.sh.game.system.arena.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ArenaDataBean extends KryoBean {

	/**
	 * 排名
	 */
	private int rank;

	/**
	 * 玩家id
	 */
	private long uid;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 战力
	 */
	private int fightPower;

	/**
	 * 称号id
	 */
	private int titleId;

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
	 * 武器id
	 */
	private int weaponId;

	/**
	 * 衣服id
	 */
	private int clothesId;


	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

	
	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	
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

	
	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	
	public int getClothesId() {
		return clothesId;
	}

	public void setClothesId(int clothesId) {
		this.clothesId = clothesId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.rank = readInt(buf, false);
		this.uid = readLong(buf);
		this.name = readString(buf);
		this.fightPower = readInt(buf, false);
		this.titleId = readInt(buf, false);
		this.windId = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.career = readInt(buf, false);
		this.weaponId = readInt(buf, false);
		this.clothesId = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, rank, false);
		this.writeLong(buf, uid);
		this.writeString(buf, name);
		this.writeInt(buf, fightPower, false);
		this.writeInt(buf, titleId, false);
		this.writeInt(buf, windId, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, weaponId, false);
		this.writeInt(buf, clothesId, false);

		return true;
	}
}

