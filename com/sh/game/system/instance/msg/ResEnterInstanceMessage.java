package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>返回副本信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResEnterInstanceMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResEnterInstanceMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20002;
	}
	
	/**
	 * 副本id
	 */
	private int instanceId;
	/**
	 * 副本唯一id
	 */
	private int uniqueId;
	/**
	 * 副本结束时间
	 */
	private int endTime;

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

		public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.instanceId = readInt(buf, false);
		this.uniqueId = readInt(buf, false);
		this.endTime = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, endTime, false);
		return true;
	}
}
