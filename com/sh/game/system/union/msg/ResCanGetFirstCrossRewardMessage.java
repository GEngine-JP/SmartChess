package com.sh.game.system.union.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送可领取行会挑战首通奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResCanGetFirstCrossRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResCanGetFirstCrossRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 23043;
	}
	
	/**
	 * 下次可领取副本id
	 */
	private int instanceId;


	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.instanceId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, instanceId, false);

		return true;
	}
}

