package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送世界boss面板信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendNewWorldBossInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendNewWorldBossInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30014;
	}
	
	/**
	 * 副本id
	 */
	private int instanceId;
	/**
	 * 当前血量
	 */
	private long hp;
	/**
	 * 活动状态 1开启
	 */
	private int state;

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

		public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

		public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.instanceId = readInt(buf, false);
		this.hp = readLong(buf);
		this.state = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, instanceId, false);
		this.writeLong(buf, hp);
		this.writeInt(buf, state, false);
		return true;
	}
}
