package com.sh.game.system.compound.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>道具合成返回</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResCompoundMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCompoundMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 31002;
	}
	
	/**
	 * 合成道具的结果
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
