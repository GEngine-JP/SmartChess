package com.sh.game.system.instance.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>发送boss血量变化信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResSendBossHpChangeMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResSendBossHpChangeMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 20008;
	}
	
	/**
	 * 剩余血量
	 */
	private long hp;

	public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.hp = readLong(buf);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeLong(buf, hp);
		return true;
	}
}
