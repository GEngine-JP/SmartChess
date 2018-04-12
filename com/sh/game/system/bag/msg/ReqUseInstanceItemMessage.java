package com.sh.game.system.bag.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求使用副本道具</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqUseInstanceItemMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqUseInstanceItemMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 10011;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;

	/**
	 * globalId(35/36)
	 */
	private int globalId;

	/**
	 * 副本id
	 */
	private int instanceId;

	/**
	 * 战报中时间 攻击药水使用要用
	 */
	private int usedTime;


	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public int getGlobalId() {
		return globalId;
	}

	public void setGlobalId(int globalId) {
		this.globalId = globalId;
	}

	
	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	
	public int getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(int usedTime) {
		this.usedTime = usedTime;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readInt(buf, false);
		this.globalId = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.usedTime = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, globalId, false);
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, usedTime, false);

		return true;
	}
}

