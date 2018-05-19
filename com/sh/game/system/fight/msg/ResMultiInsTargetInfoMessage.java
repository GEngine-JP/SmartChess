package com.sh.game.system.fight.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;

import com.sh.game.system.fight.msg.bean.RoleTargetInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>返回多人副本战斗目标信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResMultiInsTargetInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResMultiInsTargetInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 25004;
	}
	
	/**
	 * 目标信息
	 */
	private List<RoleTargetInfoBean> targetBean = new ArrayList<>();
	/**
	 * 当前的攻击模式
	 */
	private int attackPattern;
	/**
	 * 归属者id
	 */
	private long ownerId;

	public List<RoleTargetInfoBean> getTargetBean() {
		return targetBean;
	}

	public void setTargetBean(List<RoleTargetInfoBean> targetBean) {
		this.targetBean = targetBean;
	}
	public int getAttackPattern() {
		return attackPattern;
	}

	public void setAttackPattern(int attackPattern) {
		this.attackPattern = attackPattern;
	}

		public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		int targetBeanLength = readShort(buf);
		for (int targetBeanI = 0; targetBeanI < targetBeanLength; targetBeanI++) {
			if (readByte(buf) == 0) { 
				this.targetBean.add(null);
			} else {
				RoleTargetInfoBean roleTargetInfoBean = new RoleTargetInfoBean();
				roleTargetInfoBean.read(buf);
				this.targetBean.add(roleTargetInfoBean);
			}
		}		this.attackPattern = readInt(buf, false);
		this.ownerId = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.targetBean.size());
		for (int targetBeanI = 0; targetBeanI < this.targetBean.size(); targetBeanI++) {
			this.writeBean(buf, this.targetBean.get(targetBeanI));
		}		this.writeInt(buf, attackPattern, false);
		this.writeLong(buf, ownerId);
		return true;
	}
}
