package com.sh.game.system.king.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class KingRankBean extends KryoBean {

	/**
	 * 角色id
	 */
	private long roleId;
	/**
	 * 玩家名
	 */
	private String name;
	/**
	 * 排名
	 */
	private int rank;
	/**
	 * 转生
	 */
	private int rein;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 战斗力
	 */
	private int nbValue;
	/**
	 * 层数
	 */
	private int floor;
	/**
	 * 职业
	 */
	private int career;
	/**
	 * 性别
	 */
	private int sex;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

		public int getRein() {
		return rein;
	}

	public void setRein(int rein) {
		this.rein = rein;
	}

		public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		public int getNbValue() {
		return nbValue;
	}

	public void setNbValue(int nbValue) {
		this.nbValue = nbValue;
	}

		public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
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

	
	@Override
	public boolean read(KryoInput buf) {

		this.roleId = readLong(buf);
		this.name = readString(buf);
		this.rank = readInt(buf, false);
		this.rein = readInt(buf, false);
		this.level = readInt(buf, false);
		this.nbValue = readInt(buf, false);
		this.floor = readInt(buf, false);
		this.career = readInt(buf, false);
		this.sex = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, roleId);
		this.writeString(buf, name);
		this.writeInt(buf, rank, false);
		this.writeInt(buf, rein, false);
		this.writeInt(buf, level, false);
		this.writeInt(buf, nbValue, false);
		this.writeInt(buf, floor, false);
		this.writeInt(buf, career, false);
		this.writeInt(buf, sex, false);
		return true;
	}
}
