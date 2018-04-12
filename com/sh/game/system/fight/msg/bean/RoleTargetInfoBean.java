package com.sh.game.system.fight.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;

import com.sh.game.system.fight.msg.bean.RoleTargetBean;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class RoleTargetInfoBean extends KryoBean {

	/**
	 * 目标信息
	 */
	private RoleTargetBean targetInfoBean;

	/**
	 * 变化玩家id
	 */
	private long uid;


	public RoleTargetBean getTargetInfoBean() {
		return targetInfoBean;
	}

	public void setTargetInfoBean(RoleTargetBean targetInfoBean) {
		this.targetInfoBean = targetInfoBean;
	}

	
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		if (readByte(buf) != 0) {
			RoleTargetBean roleTargetBean = new RoleTargetBean();
			roleTargetBean.read(buf);
			this.targetInfoBean = roleTargetBean;
		}
		this.uid = readLong(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeBean(buf, targetInfoBean);
		this.writeLong(buf, uid);

		return true;
	}
}

