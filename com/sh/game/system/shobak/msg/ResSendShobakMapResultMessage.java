package com.sh.game.system.shobak.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送切换地图结果</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendShobakMapResultMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendShobakMapResultMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 40013;
	}
	
	/**
	 * 目标地图
	 */
	private int targetMap;


	public int getTargetMap() {
		return targetMap;
	}

	public void setTargetMap(int targetMap) {
		this.targetMap = targetMap;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.targetMap = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, targetMap, false);

		return true;
	}
}

