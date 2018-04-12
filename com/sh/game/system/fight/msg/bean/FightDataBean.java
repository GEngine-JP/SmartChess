package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.fight.msg.bean.HurtDataBean;
import com.sh.game.system.fight.msg.bean.BufferDataBean;
import java.util.List;
import java.util.ArrayList;

/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
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
	 * 时间
	 */
	private int time;

	/**
	 * 伤害列表
	 */
	private List<HurtDataBean> hurtDataBean = new ArrayList<HurtDataBean>();

	/**
	 * buff列表
	 */
	private List<BufferDataBean> bufferDataBean = new ArrayList<BufferDataBean>();


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

	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	public List<HurtDataBean> getHurtDataBean() {
		return hurtDataBean;
	}

	public void setHurtDataBean(List<HurtDataBean> hurtDataBean) {
		this.hurtDataBean = hurtDataBean;
	}

	public List<BufferDataBean> getBufferDataBean() {
		return bufferDataBean;
	}

	public void setBufferDataBean(List<BufferDataBean> bufferDataBean) {
		this.bufferDataBean = bufferDataBean;
	}


	@Override
	public boolean read(KryoInput buf) {
		this.skillId = readInt(buf, false);
		this.attacker = readString(buf);
		this.target = readString(buf);
		this.attackerId = readLong(buf);
		this.targetId = readLong(buf);
		this.time = readInt(buf, false);
		int hurtDataBeanLength = readShort(buf);
		for (int hurtDataBeanI = 0; hurtDataBeanI < hurtDataBeanLength; hurtDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.hurtDataBean.add(null);
			} else {
				HurtDataBean hurtDataBean = new HurtDataBean();
				hurtDataBean.read(buf);
				this.hurtDataBean.add(hurtDataBean);
			}
		}

		int bufferDataBeanLength = readShort(buf);
		for (int bufferDataBeanI = 0; bufferDataBeanI < bufferDataBeanLength; bufferDataBeanI++) {
			if (readByte(buf) == 0) { 
				this.bufferDataBean.add(null);
			} else {
				BufferDataBean bufferDataBean = new BufferDataBean();
				bufferDataBean.read(buf);
				this.bufferDataBean.add(bufferDataBean);
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
		this.writeInt(buf, time, false);
		writeShort(buf, this.hurtDataBean.size());
		for (int hurtDataBeanI = 0; hurtDataBeanI < this.hurtDataBean.size(); hurtDataBeanI++) {
			this.writeBean(buf, this.hurtDataBean.get(hurtDataBeanI));
		}

		writeShort(buf, this.bufferDataBean.size());
		for (int bufferDataBeanI = 0; bufferDataBeanI < this.bufferDataBean.size(); bufferDataBeanI++) {
			this.writeBean(buf, this.bufferDataBean.get(bufferDataBeanI));
		}


		return true;
	}
}

