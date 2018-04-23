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

public class AttackInfoBean extends KryoBean {

	/**
	 * 攻击者
	 */
	private long attackers;
	/**
	 * 怪物id
	 */
	private long monsterId;

	public long getAttackers() {
		return attackers;
	}

	public void setAttackers(long attackers) {
		this.attackers = attackers;
	}

		public long getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(long monsterId) {
		this.monsterId = monsterId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.attackers = readLong(buf);
		this.monsterId = readLong(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, attackers);
		this.writeLong(buf, monsterId);
		return true;
	}
}
