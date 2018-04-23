package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>请求退出副本（通用）</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ReqExitInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqExitInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20011;
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
