package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取每日充值奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetDayRechargeRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetDayRechargeRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39005;
	}
	
	/**
	 * 配置表id
	 */
	private int cfgId;

	public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cfgId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cfgId, false);
		return true;
	}
}
