package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送首充奖励信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResFirstRechargeInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResFirstRechargeInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39004;
	}
	
	/**
	 * 领取状态 0不可领取 1可领取 2已领取
	 */
	private int state;


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.state = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, state, false);

		return true;
	}
}

