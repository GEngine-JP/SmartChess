package com.sh.game.system.welfare.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class SignBean extends KryoBean {

	/**
	 * 签到奖励id
	 */
	private int rewardId;

	/**
	 * 领取状态 0不可领取 1可领取 2可再次领取 3已全部领取
	 */
	private int state;


	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.rewardId = readInt(buf, false);
		this.state = readInt(buf, false);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, rewardId, false);
		this.writeInt(buf, state, false);

		return true;
	}
}

