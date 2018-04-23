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

public class HurtDataBean extends KryoBean {

	/**
	 * 1 玩家 2英雄战 3 英雄法 4 英雄道
	 */
	private int type;
	/**
	 * 目标id
	 */
	private long targetId;
	/**
	 * 伤害值
	 */
	private int hurt;
	/**
	 * 额外效果 0无 1爆击 2威慑
	 */
	private int extraEffect;
	/**
	 * 剩余血量
	 */
	private long remainHp;
	/**
	 * 目标是否死亡
	 */
	private int isDead;
	/**
	 * 特戒触发数据
	 */
	private List<RingTriggerDataBean> ringInfo = new ArrayList<>();
	/**
	 * 名字
	 */
	private String name;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

		public long getTargetId() {
		return targetId;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

		public int getHurt() {
		return hurt;
	}

	public void setHurt(int hurt) {
		this.hurt = hurt;
	}

		public int getExtraEffect() {
		return extraEffect;
	}

	public void setExtraEffect(int extraEffect) {
		this.extraEffect = extraEffect;
	}

		public long getRemainHp() {
		return remainHp;
	}

	public void setRemainHp(long remainHp) {
		this.remainHp = remainHp;
	}

		public int getIsDead() {
		return isDead;
	}

	public void setIsDead(int isDead) {
		this.isDead = isDead;
	}

		public List<RingTriggerDataBean> getRingInfo() {
		return ringInfo;
	}

	public void setRingInfo(List<RingTriggerDataBean> ringInfo) {
		this.ringInfo = ringInfo;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.type = readInt(buf, false);
		this.targetId = readLong(buf);
		this.hurt = readInt(buf, false);
		this.extraEffect = readInt(buf, false);
		this.remainHp = readLong(buf);
		this.isDead = readInt(buf, false);
		int ringInfoLength = readShort(buf);
		for (int ringInfoI = 0; ringInfoI < ringInfoLength; ringInfoI++) {
			if (readByte(buf) == 0) { 
				this.ringInfo.add(null);
			} else {
				RingTriggerDataBean ringTriggerDataBean = new RingTriggerDataBean();
				ringTriggerDataBean.read(buf);
				this.ringInfo.add(ringTriggerDataBean);
			}
		}		this.name = readString(buf);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, type, false);
		this.writeLong(buf, targetId);
		this.writeInt(buf, hurt, false);
		this.writeInt(buf, extraEffect, false);
		this.writeLong(buf, remainHp);
		this.writeInt(buf, isDead, false);
		writeShort(buf, this.ringInfo.size());
		for (int ringInfoI = 0; ringInfoI < this.ringInfo.size(); ringInfoI++) {
			this.writeBean(buf, this.ringInfo.get(ringInfoI));
		}		this.writeString(buf, name);
		return true;
	}
}
