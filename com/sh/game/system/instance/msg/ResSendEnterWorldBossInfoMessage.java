package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>返回进入世界BOSS信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendEnterWorldBossInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendEnterWorldBossInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20005;
	}
	
	/**
	 * 副本结束时间
	 */
	private int endTime;

	/**
	 * 副本唯一id
	 */
	private int uniqueId;

	/**
	 * 副本id
	 */
	private int instanceId;


	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	
	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.endTime = readInt(buf, false);
		this.uniqueId = readInt(buf, false);
		this.instanceId = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, endTime, false);
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, instanceId, false);

		return true;
	}
}

