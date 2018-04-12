package com.sh.game.system.shobak.msg.bean;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.net.kryo.KryoBean;



/**
 * <p></p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class MonsterInfoBean extends KryoBean {

	/**
	 * 血量
	 */
	private long hp;

	/**
	 * 怪物id
	 */
	private long monsterId;


	public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	
	public long getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(long monsterId) {
		this.monsterId = monsterId;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.hp = readLong(buf);
		this.monsterId = readLong(buf);

		return true;
	}
	
	@Override
	public boolean write(KryoOutput buf) {
		this.writeLong(buf, hp);
		this.writeLong(buf, monsterId);

		return true;
	}
}

