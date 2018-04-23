package com.sh.game.system.tower.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class TowerRankBean extends KryoBean {

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
	 * VIP等级
	 */
	private int vip;
	/**
	 * 月卡
	 */
	private int monthCard;
	/**
	 * 重天
	 */
	private int group;
	/**
	 * 层数
	 */
	private int storey;

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

		public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

		public int getMonthCard() {
		return monthCard;
	}

	public void setMonthCard(int monthCard) {
		this.monthCard = monthCard;
	}

		public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

		public int getStorey() {
		return storey;
	}

	public void setStorey(int storey) {
		this.storey = storey;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.roleId = readLong(buf);
		this.name = readString(buf);
		this.rank = readInt(buf, false);
		this.vip = readInt(buf, false);
		this.monthCard = readInt(buf, false);
		this.group = readInt(buf, false);
		this.storey = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, roleId);
		this.writeString(buf, name);
		this.writeInt(buf, rank, false);
		this.writeInt(buf, vip, false);
		this.writeInt(buf, monthCard, false);
		this.writeInt(buf, group, false);
		this.writeInt(buf, storey, false);
		return true;
	}
}
