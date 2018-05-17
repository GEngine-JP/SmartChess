package com.sh.game.system.battle.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class BattleDataBean extends KryoBean {

	/**
	 * 技能id
	 */
	private int skillId;
	/**
	 * 攻击者名字
	 */
	private String attacker;
	/**
	 * 被攻击者名字
	 */
	private String target;
	/**
	 * 攻击者id
	 */
	private long attackerId;
	/**
	 * 被攻击者id
	 */
	private long targetId;
	/**
	 * 回合数
	 */
	private int round;
	/**
	 * 伤害列表
	 */
	private List<HurtDataBean> hurtDataBean = new ArrayList<>();
	/**
	 * 对自己加的buff
	 */
	private List<BufferAdd> selfBuff = new ArrayList<>();

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

		public String getAttacker() {
		return attacker;
	}

	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}

		public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

		public long getAttackerId() {
		return attackerId;
	}

	public void setAttackerId(long attackerId) {
		this.attackerId = attackerId;
	}

		public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

		public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

		public List<HurtDataBean> getHurtDataBean() {
		return hurtDataBean;
	}

	public void setHurtDataBean(List<HurtDataBean> hurtDataBean) {
		this.hurtDataBean = hurtDataBean;
	}
	public List<BufferAdd> getSelfBuff() {
		return selfBuff;
	}

	public void setSelfBuff(List<BufferAdd> selfBuff) {
		this.selfBuff = selfBuff;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.skillId = readInt(buf, false);
		this.attacker = readString(buf);
		this.target = readString(buf);
		this.attackerId = readLong(buf);
		this.targetId = readLong(buf);
		this.round = readInt(buf, false);
		int hurtDataBeanLength = readShort(buf);
		for (int hurtDataBeanI = 0; hurtDataBeanI < hurtDataBeanLength; hurtDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.hurtDataBean.add(null);
			} else {
				HurtDataBean hurtDataBean = new HurtDataBean();
				hurtDataBean.read(buf);
				this.hurtDataBean.add(hurtDataBean);
			}
		}		int selfBuffLength = readShort(buf);
		for (int selfBuffI = 0; selfBuffI < selfBuffLength; selfBuffI++) {
			if (readByte(buf) == 0) { 
				this.selfBuff.add(null);
			} else {
				BufferAdd bufferAdd = new BufferAdd();
				bufferAdd.read(buf);
				this.selfBuff.add(bufferAdd);
			}
		}
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, skillId, false);
		this.writeString(buf, attacker);
		this.writeString(buf, target);
		this.writeLong(buf, attackerId);
		this.writeLong(buf, targetId);
		this.writeInt(buf, round, false);
		writeShort(buf, this.hurtDataBean.size());
		for (int hurtDataBeanI = 0; hurtDataBeanI < this.hurtDataBean.size(); hurtDataBeanI++) {
			this.writeBean(buf, this.hurtDataBean.get(hurtDataBeanI));
		}		writeShort(buf, this.selfBuff.size());
		for (int selfBuffI = 0; selfBuffI < this.selfBuff.size(); selfBuffI++) {
			this.writeBean(buf, this.selfBuff.get(selfBuffI));
		}
		return true;
	}
}
