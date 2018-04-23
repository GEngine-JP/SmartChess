package com.sh.game.system.forenotice.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领奖</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqGetForenoticeRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqGetForenoticeRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 29002;
	}
	
	/**
	 * system_open配置id
	 */
	private int configId;

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.configId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, configId, false);
		return true;
	}
}
