package com.sh.game.system.recharge.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>发送充值界面信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendRechargeInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRechargeInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 39002;
	}
	
	/**
	 * 已获得购买双倍的奖励的配置id
	 */
	private List<Integer> cfgId = new ArrayList<>();

	public List<Integer> getCfgId() {
		return cfgId;
	}

	public void setCfgId(List<Integer> cfgId) {
		this.cfgId = cfgId;
	}

	@Override
	public boolean read(KryoInput buf) {

		int cfgIdLength = readShort(buf);
		for (int cfgIdI = 0; cfgIdI < cfgIdLength; cfgIdI++) {
			this.cfgId.add(this.readInt(buf, false));
		}
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		writeShort(buf, this.cfgId.size());
		for (int cfgIdI = 0; cfgIdI < this.cfgId.size(); cfgIdI++) {
			this.writeInt(buf, this.cfgId.get(cfgIdI), false);
		}
		return true;
	}
}
