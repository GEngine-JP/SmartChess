package com.sh.game.system.back.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class UnionMemberInfoBean1 extends KryoBean {

	/**
	 * 玩家id
	 */
	private long id;
	/**
	 * 成员名称
	 */
	private String memberName;
	/**
	 * 成员职位
	 */
	private int position;
	/**
	 * 成员等级
	 */
	private int memberLevel;
	/**
	 * 战力
	 */
	private int fightPower;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * vip等级
	 */
	private int vipLevel;
	/**
	 * 充值额
	 */
	private int recharge;

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

		public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

		public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

		public int getFightPower() {
		return fightPower;
	}

	public void setFightPower(int fightPower) {
		this.fightPower = fightPower;
	}

		public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

		public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

		public int getRecharge() {
		return recharge;
	}

	public void setRecharge(int recharge) {
		this.recharge = recharge;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.id = readLong(buf);
		this.memberName = readString(buf);
		this.position = readInt(buf, false);
		this.memberLevel = readInt(buf, false);
		this.fightPower = readInt(buf, false);
		this.sex = readInt(buf, false);
		this.vipLevel = readInt(buf, false);
		this.recharge = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, id);
		this.writeString(buf, memberName);
		this.writeInt(buf, position, false);
		this.writeInt(buf, memberLevel, false);
		this.writeInt(buf, fightPower, false);
		this.writeInt(buf, sex, false);
		this.writeInt(buf, vipLevel, false);
		this.writeInt(buf, recharge, false);
		return true;
	}
}
