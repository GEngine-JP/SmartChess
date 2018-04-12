package com.sh.game.system.boss.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>发送轮回boss面板信息</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ResSendRecycleBossInfoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendRecycleBossInfoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 30012;
	}
	
	/**
	 * 副本id
	 */
	private int instanceId;

	/**
	 * 归属者行会名 没有帮会发归属者名字
	 */
	private String unionName;

	/**
	 * 当前血量
	 */
	private long hp;


	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	
	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	
	public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.instanceId = readInt(buf, false);
		this.unionName = readString(buf);
		this.hp = readLong(buf);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, instanceId, false);
		this.writeString(buf, unionName);
		this.writeLong(buf, hp);

		return true;
	}
}

