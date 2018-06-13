package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>充值惊喜消息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendRechargeSurpriseMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRechargeSurpriseMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39008;
	}
	
	/**
	 * 配置表id
	 */
	private int cfgId;
	/**
	 * 奖励领取状态0未领取1可领取2已领取
	 */
	private int state;

	public int getCfgId() {
		return cfgId;
	}

	public void setCfgId(int cfgId) {
		this.cfgId = cfgId;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.cfgId = readInt(buf, false);
		this.state = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, cfgId, false);
		this.writeInt(buf, state, false);
		return true;
	}
}
