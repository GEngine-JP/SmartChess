package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>手动领取副本奖励</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqManualGetInstanceRewardMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqManualGetInstanceRewardMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20027;
	}
	
	/**
	 * 副本唯一id
	 */
	private int uniqueId;

	/**
	 * 副本id
	 */
	private int instanceId;

	/**
	 * 领取倍率
	 */
	private int multi;


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

	
	public int getMulti() {
		return multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.uniqueId = readInt(buf, false);
		this.instanceId = readInt(buf, false);
		this.multi = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, uniqueId, false);
		this.writeInt(buf, instanceId, false);
		this.writeInt(buf, multi, false);

		return true;
	}
}

