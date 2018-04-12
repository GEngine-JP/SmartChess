package com.sh.game.system.compound.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求合成道具</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqCompoundMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCompoundMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 31001;
	}
	
	/**
	 * 配置表的id
	 */
	private int configId;

	/**
	 * 合成次数
	 */
	private int count;


	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.configId = readInt(buf, false);
		this.count = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, configId, false);
		this.writeInt(buf, count, false);

		return true;
	}
}

