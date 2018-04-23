package com.sh.game.system.fabao.msg;

import com.sh.net.kryo.KryoInput;
import com.sh.net.kryo.KryoOutput;
import com.sh.game.server.AbstractMessage;


/**
 * <p>法宝信息</p>
 * <p>Created by MessageUtil</p>
 *
 * @author : admin
 */

public class ResLevelUpFaBaoMessage extends AbstractMessage {

	@Override
	public void doAction() {
		
	}
	
	public ResLevelUpFaBaoMessage() {
		this.queueId = 2;
	}
	
	@Override
	public int getId() {
		return 57002;
	}
	
	/**
	 * 法宝id
	 */
	private int fabaoId;

	public int getFabaoId() {
		return fabaoId;
	}

	public void setFabaoId(int fabaoId) {
		this.fabaoId = fabaoId;
	}

	
	@Override
	public boolean read(KryoInput buf) {

		this.fabaoId = readInt(buf, false);
		return true;
	}

	@Override
	public boolean write(KryoOutput buf) {

		this.writeInt(buf, fabaoId, false);
		return true;
	}
}
