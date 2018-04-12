package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求查看BOSS击杀记录</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqBossKillRecordMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqBossKillRecordMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30004;
	}
	
	/**
	 * 副本id
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

