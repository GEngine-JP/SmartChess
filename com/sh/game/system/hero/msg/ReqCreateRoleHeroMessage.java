package com.sh.game.system.hero.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;



/**
 * <p>请求创建英雄</p>
 * <p>Created by MessageUtil</p>
 * @author : lanyue group
 */
public class ReqCreateRoleHeroMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ReqCreateRoleHeroMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 22003;
	}
	
	/**
	 * 英雄职业
	 */
	private int career;


	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	

	@Override
	public boolean read(KryoInput buf) {
		this.career = readInt(buf, false);

		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {
		this.writeInt(buf, career, false);

		return true;
	}
}

