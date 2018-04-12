package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求领取积分达标奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqGetScoreAttachRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetScoreAttachRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40012;
	}
	
	/**
	 * 对应达标配置表id
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

