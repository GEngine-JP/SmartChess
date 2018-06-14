package com.sh.game.system.digtreausre.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求领取藏宝图奖励</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqDrawTreasureMapRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqDrawTreasureMapRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 65001;
	}
	
	/**
	 * 副本Id
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