package com.sh.game.system.fight.msg.bean;

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

public class FightDataBean extends KryoBean {

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
	 * 暴击列表
	 */
	private List<Long> criticalList = new ArrayList<>();
	/**
	 * 威慑列表
	 */
	private List<Long> overaweList = new ArrayList<>();
	/**
	 * 伤害列表
	 */
	private List<HurtTarget> hurtDataBean = new ArrayList<>();
	/**
	 * buff列表
	 */
	private List<BufferAdd> bufferDataBean = new ArrayList<>();

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

		public List<Long> getCriticalList() {
		return criticalList;
	}

	public void setCriticalList(List<Long> criticalList) {
		this.criticalList = criticalList;
	}
	public List<Long> getOveraweList() {
		return overaweList;
	}

	public void setOveraweList(List<Long> overaweList) {
		this.overaweList = overaweList;
	}
	public List<HurtTarget> getHurtDataBean() {
		return hurtDataBean;
	}

	public void setHurtDataBean(List<HurtTarget> hurtDataBean) {
		this.hurtDataBean = hurtDataBean;
	}
	public List<BufferAdd> getBufferDataBean() {
		return bufferDataBean;
	}

	public void setBufferDataBean(List<BufferAdd> bufferDataBean) {
		this.bufferDataBean = bufferDataBean;
	}

	@Override
	public boolean read(KryoInput buf) {

		this.skillId = readInt(buf, false);
		this.attacker = readString(buf);
		this.target = readString(buf);
		this.attackerId = readLong(buf);
		this.targetId = readLong(buf);
		this.round = readInt(buf, false);
		int criticalListLength = readShort(buf);
		for (int criticalListI = 0; criticalListI < criticalListLength; criticalListI++) {
			this.criticalList.add(this.readLong(buf));
		}		int overaweListLength = readShort(buf);
		for (int overaweListI = 0; overaweListI < overaweListLength; overaweListI++) {
			this.overaweList.add(this.readLong(buf));
		}		int hurtDataBeanLength = readShort(buf);
		for (int hurtDataBeanI = 0; hurtDataBeanI < hurtDataBeanLength; hurtDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.hurtDataBean.add(null);
			} else {
				HurtTarget hurtTarget = new HurtTarget();
				hurtTarget.read(buf);
				this.hurtDataBean.add(hurtTarget);
			}
		}		int bufferDataBeanLength = readShort(buf);
		for (int bufferDataBeanI = 0; bufferDataBeanI < bufferDataBeanLength; bufferDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.bufferDataBean.add(null);
			} else {
				BufferAdd bufferAdd = new BufferAdd();
				bufferAdd.read(buf);
				this.bufferDataBean.add(bufferAdd);
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
		writeShort(buf, this.criticalList.size());
		for (int criticalListI = 0; criticalListI < this.criticalList.size(); criticalListI++) {
			this.writeLong(buf, this.criticalList.get(criticalListI));
		}		writeShort(buf, this.overaweList.size());
		for (int overaweListI = 0; overaweListI < this.overaweList.size(); overaweListI++) {
			this.writeLong(buf, this.overaweList.get(overaweListI));
		}		writeShort(buf, this.hurtDataBean.size());
		for (int hurtDataBeanI = 0; hurtDataBeanI < this.hurtDataBean.size(); hurtDataBeanI++) {
			this.writeBean(buf, this.hurtDataBean.get(hurtDataBeanI));
		}		writeShort(buf, this.bufferDataBean.size());
		for (int bufferDataBeanI = 0; bufferDataBeanI < this.bufferDataBean.size(); bufferDataBeanI++) {
			this.writeBean(buf, this.bufferDataBean.get(bufferDataBeanI));
		}
		return true;
	}
}
