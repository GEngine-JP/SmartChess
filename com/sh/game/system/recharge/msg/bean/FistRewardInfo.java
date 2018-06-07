package com.sh.game.system.recharge.msg.bean;

import com.sh.net.kryo.KryoBean;
import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;


/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class FistRewardInfo extends KryoBean {

	/**
	 * 充值id
	 */
	private int rechargeId;
	/**
	 * 领取状态 0不可领取 1可领取 2已领取
	 */
	private int state;

	public int getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(int rechargeId) {
		this.rechargeId = rechargeId;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.rechargeId = readInt(buf, false);
		this.state = readInt(buf, false);
		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, rechargeId, false);
		this.writeInt(buf, state, false);
		return true;
	}
}
